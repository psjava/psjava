package org.psjava.algo;

import org.psjava.algo.graph.shortestpath.AllPairShortestPathResult;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

import java.util.function.Function;

public interface AllPairShortestPath {
    <V, W, E extends DirectedEdge<V>> AllPairShortestPathResult<V, W, E> calc(Graph<V, E> graph, Function<E, W> weightFunction, AddableNumberSystem<W> ns);
}
