package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.SingleElementCollection;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.DirectedWeightedEdgeFactory;
import org.psjava.ds.graph.DirectedWeightedGraph;
import org.psjava.ds.map.JavaHashMapFactory;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.javautil.ConvertedDataIterable;
import org.psjava.javautil.DataConverter;
import org.psjava.javautil.MergedCollection;
import org.psjava.javautil.MergedIterable;
import org.psjava.javautil.VarargsIterable;
import org.psjava.math.ns.AddableNumberSystem;

public class Johnson implements AllPairShortestPath {

	private static final MutableMapFactory MF = JavaHashMapFactory.getInstance();

	/**
	 * Johnson's algorithm allows negative edge weight. but not negative cycles.
	 * Faster than floyd-warshall's algorithm in sparse graph.
	 */

	private static final Object VIRTUAL_START = new Object();

	private BellmanFord bellmanFord;
	private Dijkstra dijkstra;

	public Johnson(BellmanFord bellmanFord, Dijkstra dijkstra) {
		this.bellmanFord = bellmanFord;
		this.dijkstra = dijkstra;
	}

	@Override
	public <W> AllPairShortestPathResult<W> calc(DirectedWeightedGraph<W> graph, AddableNumberSystem<W> ns) {
		DirectedWeightedGraph<W> augmented = createAugmentedGraph(graph, ns);
		SingleSourceShortestPathResult<W> bellmanFordResult = bellmanFord.calc(augmented, VIRTUAL_START, ns);
		DirectedWeightedGraph<W> reweighted = reweight(graph, bellmanFordResult, ns);
		MutableMap<Object, SingleSourceShortestPathResult<W>> dijsktraResult = MF.create();
		for (Object v : graph.getVertices())
			dijsktraResult.put(v, dijkstra.calc(reweighted, v, ns));
		return createUnreweightedResult(bellmanFordResult, dijsktraResult, ns);
	}

	@SuppressWarnings("unchecked")
	private static <W> DirectedWeightedGraph<W> createAugmentedGraph(final DirectedWeightedGraph<W> g, final AddableNumberSystem<W> ns) {
		final DynamicArray<DirectedWeightedEdge<W>> moreEdges = DynamicArray.create();
		for (Object v : g.getVertices())
			moreEdges.addToLast(DirectedWeightedEdgeFactory.create(VIRTUAL_START, v, ns.getZero()));
		return new DirectedWeightedGraph<W>() {
			@Override
			public Collection<Object> getVertices() {
				return MergedCollection.wrap(VarargsIterable.create(g.getVertices(), SingleElementCollection.create(VIRTUAL_START)));
			}

			@Override
			public Iterable<DirectedWeightedEdge<W>> getEdges() {
				return MergedIterable.wrap(VarargsIterable.create(g.getEdges(), moreEdges));
			}
		};
	}

	// TODO use common code if SuccessiveShortestPathWithPotential can use this.
	private static <W> DirectedWeightedGraph<W> reweight(final DirectedWeightedGraph<W> graph, final SingleSourceShortestPathResult<W> shotestPathResult, final AddableNumberSystem<W> ns) {
		return new DirectedWeightedGraph<W>() {
			@Override
			public Collection<Object> getVertices() {
				return graph.getVertices();
			}

			@Override
			public Iterable<DirectedWeightedEdge<W>> getEdges() {
				return ConvertedDataIterable.create(graph.getEdges(), new DataConverter<DirectedWeightedEdge<W>, DirectedWeightedEdge<W>>() {
					@Override
					public DirectedWeightedEdge<W> convert(DirectedWeightedEdge<W> e) {
						W adjust = ns.subtract(shotestPathResult.getDistance(e.from()), shotestPathResult.getDistance(e.to()));
						return DirectedWeightedEdgeFactory.create(e.from(), e.to(), ns.add(e.weight(), adjust));
					}
				});
			}
		};
	}

	private static <W> AllPairShortestPathResult<W> createUnreweightedResult(final SingleSourceShortestPathResult<W> bellmanFordResult, final MutableMap<Object, SingleSourceShortestPathResult<W>> dijkstraResult, final AddableNumberSystem<W> ns) {
		return new AllPairShortestPathResult<W>() {
			@Override
			public W getDistance(Object from, Object to) {
				W adjust = ns.subtract(bellmanFordResult.getDistance(to), bellmanFordResult.getDistance(from));
				return ns.add(dijkstraResult.get(from).getDistance(to), adjust);
			}

			@Override
			public Iterable<DirectedWeightedEdge<W>> getPath(final Object from, Object to) {
				return ConvertedDataIterable.create(dijkstraResult.get(from).getPath(to), new DataConverter<DirectedWeightedEdge<W>, DirectedWeightedEdge<W>>() {
					@Override
					public DirectedWeightedEdge<W> convert(DirectedWeightedEdge<W> v) {
						return DirectedWeightedEdgeFactory.create(v.from(), v.to(), getDistance(v.from(), v.to()));
					}
				});
			}

			@Override
			public boolean isReachable(Object from, Object to) {
				return dijkstraResult.get(from).isReachable(to);
			}
		};
	}

}
