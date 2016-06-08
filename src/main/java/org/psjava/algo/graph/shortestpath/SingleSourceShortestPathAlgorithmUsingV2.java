package org.psjava.algo.graph.shortestpath;

import org.psjava.algo.SingleSourceShortestPathAlgorithmV2;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

@Deprecated
public class SingleSourceShortestPathAlgorithmUsingV2 {

    public static SingleSourceShortestPathAlgorithm wrap(final SingleSourceShortestPathAlgorithmV2 v2) {
        return new SingleSourceShortestPathAlgorithm() {
            @Override
            public <V, W, E extends DirectedWeightedEdge<V, W>> SingleSourceShortestPathResult<V, W, E> calc(Graph<V, E> graph, V start, final AddableNumberSystem<W> weightSystem) {
                return v2.calc(graph, new Function<E, W>() {
                    @Override
                    public W get(E edge) {
                        return edge.weight();
                    }
                }, start, weightSystem);
            }
        };
    }
}
