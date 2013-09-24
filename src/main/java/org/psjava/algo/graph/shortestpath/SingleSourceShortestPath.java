package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedGraph;
import org.psjava.math.ns.AddableNumberSystem;

public interface SingleSourceShortestPath {
	<V, W> SingleSourceShortestPathResult<V, W> calc(DirectedWeightedGraph<V, W> graph, V from, AddableNumberSystem<W> ns);
}
