package org.psjava.algo;

import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathCalcStatus;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.numbersystrem.InfinitableAddableNumberSystem;

import java.util.function.Function;

public interface SingleSourceShortestPathAlgorithmMaterial {
    <V, W, E extends DirectedEdge<V>> SingleSourceShortestPathCalcStatus<V, W, E> calc(Graph<V, E> graph, V start, Function<E, W> weightFunction, final InfinitableAddableNumberSystem<W> ns);
}
