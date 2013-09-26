package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.math.ns.AddableNumberSystem;

public interface AllPairShortestPath {
	<V, W, E extends DirectedWeightedEdge<V, W>> AllPairShortestPathResult<V, W, E> calc(Graph<V, E> graph, AddableNumberSystem<W> ns);
}
