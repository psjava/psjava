package org.psjava.algo.graph.shortestpath;

import org.psjava.algo.AllPairShortestPath;
import org.psjava.algo.SingleSourceShortestPathAlgorithm;
import org.psjava.ds.graph.AllEdgeInGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.SimpleDirectedWeightedEdge;
import org.psjava.ds.graph.SimpleDirectedWeightedGraph;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.goods.GoodMutableMapFactory;

import java.util.function.Function;

/**
 * Johnson's algorithm allows negative edge weight. but not negative cycles.
 * <p>
 * Faster than floyd-warshall's algorithm in sparse graph.
 */

public class JohnsonAlgorithm {

    private static final Object VIRTUAL_START = new Object();

    public static AllPairShortestPath getInstance(final SingleSourceShortestPathAlgorithm bellmanFord, final SingleSourceShortestPathAlgorithm dijkstra) {
        return new AllPairShortestPath() {
            @Override
            public <V, W, E extends DirectedEdge<V>> AllPairShortestPathResult<V, W, E> calc(Graph<V, E> graph, final Function<E, W> weight, final AddableNumberSystem<W> ns) {
                final SimpleDirectedWeightedGraph<Object, W> augmented = augment(graph, weight, ns);
                final SingleSourceShortestPathResult<Object, W, SimpleDirectedWeightedEdge<Object, W>> bellmanFordResult = bellmanFord.calc(augmented, augmented.getWeightFunction(), VIRTUAL_START, ns);
                Function<E, W> reweightedFunction = reweight(weight, bellmanFordResult, ns);
                MutableMap<V, SingleSourceShortestPathResult<V, W, E>> dijsktraResult = GoodMutableMapFactory.getInstance().create();
                for (V v : graph.getVertices())
                    dijsktraResult.add(v, dijkstra.calc(graph, reweightedFunction, v, ns));
                return createUnreweightedResult(bellmanFordResult, dijsktraResult, ns);
            }
        };
    }

    private static <V, W, E extends DirectedEdge<V>> SimpleDirectedWeightedGraph<Object, W> augment(Graph<V, E> original, Function<E, W> weight, final AddableNumberSystem<W> ns) {
        SimpleDirectedWeightedGraph<Object, W> res = SimpleDirectedWeightedGraph.create();
        res.insertVertex(VIRTUAL_START);
        for (Object v : original.getVertices()) {
            res.insertVertex(v);
            res.addEdge(VIRTUAL_START, v, ns.getZero());
        }
        for (E e : AllEdgeInGraph.wrap(original))
            res.addEdge(e.from(), e.to(), weight.apply(e));
        return res;
    }

    private static <V, W, E extends DirectedEdge<V>> Function<E, W> reweight(final Function<E, W> original, final SingleSourceShortestPathResult<Object, W, SimpleDirectedWeightedEdge<Object, W>> bellmanFordResult, final AddableNumberSystem<W> ns) {
        return new Function<E, W>() {
            @Override
            public W apply(E e) {
                W adjust = ns.subtract(bellmanFordResult.getDistance(e.from()), bellmanFordResult.getDistance(e.to()));
                return ns.add(original.apply(e), adjust);
            }
        };
    }

    private static <V, W, E> AllPairShortestPathResult<V, W, E> createUnreweightedResult(final SingleSourceShortestPathResult<Object, W, SimpleDirectedWeightedEdge<Object, W>> bellmanFordResult, final MutableMap<V, SingleSourceShortestPathResult<V, W, E>> dijkstraResult, final AddableNumberSystem<W> ns) {
        return new AllPairShortestPathResult<V, W, E>() {
            @Override
            public W getDistance(V from, V to) {
                W adjust = ns.subtract(bellmanFordResult.getDistance(to), bellmanFordResult.getDistance(from));
                return ns.add(dijkstraResult.get(from).getDistance(to), adjust);
            }

            @Override
            public Iterable<E> getPath(final V from, V to) {
                return dijkstraResult.get(from).getPath(to);
            }

            @Override
            public boolean isReachable(V from, V to) {
                return dijkstraResult.get(from).isReachable(to);
            }
        };
    }

}
