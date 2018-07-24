package org.psjava.algo.graph.shortestpath;

import org.psjava.algo.Relax;
import org.psjava.algo.SingleSourceShortestPathAlgorithm;
import org.psjava.ds.graph.AllEdgeInGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.ds.numbersystrem.InfinitableAddableNumberSystem;
import org.psjava.util.Assertion;

import java.util.function.Function;

public class BellmanFordAlgorithm {

    public static SingleSourceShortestPathAlgorithm getInstance() {
        return new SingleSourceShortestPathAlgorithm() {
            @Override
            public <V, W, E extends DirectedEdge<V>> SingleSourceShortestPathResult<V, W, E> calc(Graph<V, E> graph, Function<E, W> weight, V from, AddableNumberSystem<W> weightSystem) {
                InfinitableAddableNumberSystem<W> ns = InfinitableAddableNumberSystem.wrap(weightSystem);
                SingleSourceShortestPathCalcStatus<V, W, E> status = createInitialStatus(graph, from, ns);
                relaxEnough(graph, weight, status, ns);
                relaxToCheckNegativeCycle(graph, weight, status, ns);
                return SingleSourceShortestPathResultFactory.create(from, status.distance, status.previous);
            }
        };
    }

    static <V, E, W> SingleSourceShortestPathCalcStatus<V, W, E> createInitialStatus(Graph<V, E> graph, V from, InfinitableAddableNumberSystem<W> ns) {
        SingleSourceShortestPathCalcStatus<V, W, E> status = new SingleSourceShortestPathCalcStatus<V, W, E>();
        for (V v : graph.getVertices())
            status.distance.add(v, ns.getInfinity());
        status.distance.replace(from, ns.getZero());
        return status;
    }

    static <V, W, E extends DirectedEdge<V>> void relaxEnough(Graph<V, E> graph, Function<E, W> weight, SingleSourceShortestPathCalcStatus<V, W, E> status, InfinitableAddableNumberSystem<W> ns) {
        for (int i = 0; i < graph.getVertices().size() - 1; i++)
            for (E e : AllEdgeInGraph.wrap(graph))
                Relax.relax(status.distance, status.previous, e, weight, ns);
    }

    private static <V, W, E extends DirectedEdge<V>> void relaxToCheckNegativeCycle(Graph<V, E> graph, Function<E, W> weight, SingleSourceShortestPathCalcStatus<V, W, E> status, InfinitableAddableNumberSystem<W> ns) {
        for (E e : AllEdgeInGraph.wrap(graph)) {
            boolean relaxed = Relax.relax(status.distance, status.previous, e, weight, ns);
            Assertion.ensure(!relaxed, "contains negative cycle");
        }
    }

}
