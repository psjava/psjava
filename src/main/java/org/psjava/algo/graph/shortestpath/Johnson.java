package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.Collection;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.DirectedWeightedEdgeFactory;
import org.psjava.ds.graph.DirectedWeightedGraph;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.javautil.ConvertedDataIterable;
import org.psjava.javautil.DataConverter;
import org.psjava.math.ns.AddableNumberSystem;

/**
 * Johnson's algorithm allows negative edge weight. but not negative cycles.
 * 
 * Faster than floyd-warshall's algorithm in sparse graph.
 */

public class Johnson implements AllPairShortestPath {

	private static final Object VIRTUAL_START = new Object();

	private BellmanFord bellmanFord;
	private Dijkstra dijkstra;

	public Johnson(BellmanFord bellmanFord, Dijkstra dijkstra) {
		this.bellmanFord = bellmanFord;
		this.dijkstra = dijkstra;
	}

	@Override
	public <V, W> AllPairShortestPathResult<V, W> calc(DirectedWeightedGraph<V, W> graph, AddableNumberSystem<W> ns) {
		DirectedWeightedGraph<Object, W> augmented = augment(graph, ns);
		SingleSourceShortestPathResult<Object, W> bellmanFordResult = bellmanFord.calc(augmented, VIRTUAL_START, ns);
		DirectedWeightedGraph<V, W> reweighted = reweight(graph, bellmanFordResult, ns);
		MutableMap<V, SingleSourceShortestPathResult<V, W>> dijsktraResult = GoodMutableMapFactory.getInstance().create();
		for (V v : graph.getVertices())
			dijsktraResult.put(v, dijkstra.calc(reweighted, v, ns));
		return createUnreweightedResult(bellmanFordResult, dijsktraResult, ns);
	}

	private static <V, W> DirectedWeightedGraph<Object, W> augment(final DirectedWeightedGraph<V, W> g, final AddableNumberSystem<W> ns) {
		MutableDirectedWeightedGraph<Object, W> res = MutableDirectedWeightedGraph.create();
		res.insertVertex(VIRTUAL_START);
		for (Object v : g.getVertices()) {
			res.insertVertex(v);
			res.addEdge(VIRTUAL_START, v, ns.getZero());
		}
		for (DirectedWeightedEdge<V, W> e : g.getEdges())
			res.addEdge(e.from(), e.to(), e.weight());
		return res;
	}

	// TODO use common code if SuccessiveShortestPathWithPotential can use this.
	private static <V, W> DirectedWeightedGraph<V, W> reweight(final DirectedWeightedGraph<V, W> graph, final SingleSourceShortestPathResult<Object, W> bellmanFordResult, final AddableNumberSystem<W> ns) {
		return new DirectedWeightedGraph<V, W>() {
			@Override
			public Collection<V> getVertices() {
				return graph.getVertices();
			}

			@Override
			public Iterable<DirectedWeightedEdge<V, W>> getEdges() {
				return ConvertedDataIterable.create(graph.getEdges(), new DataConverter<DirectedWeightedEdge<V, W>, DirectedWeightedEdge<V, W>>() {
					@Override
					public DirectedWeightedEdge<V, W> convert(DirectedWeightedEdge<V, W> e) {
						W adjust = ns.subtract(bellmanFordResult.getDistance(e.from()), bellmanFordResult.getDistance(e.to()));
						return DirectedWeightedEdgeFactory.create(e.from(), e.to(), ns.add(e.weight(), adjust));
					}
				});
			}
		};
	}

	private static <V, W> AllPairShortestPathResult<V, W> createUnreweightedResult(final SingleSourceShortestPathResult<Object, W> bellmanFordResult, final MutableMap<V, SingleSourceShortestPathResult<V, W>> dijkstraResult, final AddableNumberSystem<W> ns) {
		return new AllPairShortestPathResult<V, W>() {
			@Override
			public W getDistance(V from, V to) {
				W adjust = ns.subtract(bellmanFordResult.getDistance(to), bellmanFordResult.getDistance(from));
				return ns.add(dijkstraResult.get(from).getDistance(to), adjust);
			}

			@Override
			public Iterable<DirectedWeightedEdge<V, W>> getPath(final V from, V to) {
				return ConvertedDataIterable.create(dijkstraResult.get(from).getPath(to), new DataConverter<DirectedWeightedEdge<V, W>, DirectedWeightedEdge<V, W>>() {
					@Override
					public DirectedWeightedEdge<V, W> convert(DirectedWeightedEdge<V, W> v) {
						return DirectedWeightedEdgeFactory.create(v.from(), v.to(), getDistance(v.from(), v.to()));
					}
				});
			}

			@Override
			public boolean isReachable(V from, V to) {
				return dijkstraResult.get(from).isReachable(to);
			}
		};
	}

}
