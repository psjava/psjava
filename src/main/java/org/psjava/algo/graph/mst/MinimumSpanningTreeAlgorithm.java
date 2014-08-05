package org.psjava.algo.graph.mst;

import org.psjava.ds.Collection;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.UndirectedWeightedEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public interface MinimumSpanningTreeAlgorithm {
	<T, V, E extends UndirectedWeightedEdge<V, T>> Collection<E> calc(Graph<V, E> graph, AddableNumberSystem<T> ns);
}