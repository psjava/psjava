package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public interface AllPairShortestPathV2 {
    <V, W, E extends DirectedEdge<V>> AllPairShortestPathResult<V, W, E> calc(Graph<V, E> graph, Function<E, W> weightFunction, AddableNumberSystem<W> ns);
}
