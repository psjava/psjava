package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.OldGraph;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public interface AllPairShortestPath {
	<V, W, E extends DirectedWeightedEdge<V, W>> AllPairShortestPathResult<V, W, E> calc(OldGraph<V, E> oldGraph, AddableNumberSystem<W> ns);
}
