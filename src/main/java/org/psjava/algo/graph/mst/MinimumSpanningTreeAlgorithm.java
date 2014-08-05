package org.psjava.algo.graph.mst;

import org.psjava.ds.graph.OldGraph;
import org.psjava.ds.graph.UndirectedWeightedEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public interface MinimumSpanningTreeAlgorithm {
	<T, V, E extends UndirectedWeightedEdge<V, T>> OldGraph<V, E> calc(OldGraph<V, E> oldGraph, AddableNumberSystem<T> ns);
}