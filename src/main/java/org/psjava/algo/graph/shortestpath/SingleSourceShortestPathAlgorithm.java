package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.OldGraph;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public interface SingleSourceShortestPathAlgorithm {
	<V, W, E extends DirectedWeightedEdge<V, W>> SingleSourceShortestPathResult<V, W, E> calc(OldGraph<V, E> oldGraph, V from, AddableNumberSystem<W> ns);
}
