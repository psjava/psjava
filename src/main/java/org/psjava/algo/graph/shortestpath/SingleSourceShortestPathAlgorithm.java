package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

@Deprecated
public interface SingleSourceShortestPathAlgorithm {
	<V, W, E extends DirectedWeightedEdge<V, W>> SingleSourceShortestPathResult<V, W, E> calc(Graph<V, E> graph, V from, AddableNumberSystem<W> ns);
}
