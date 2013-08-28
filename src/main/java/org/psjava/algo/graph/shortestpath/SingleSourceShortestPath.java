package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedGraph;
import org.psjava.math.ns.AddableNumberSystem;

public interface SingleSourceShortestPath {
	<W> SingleSourceShortestPathResult<W> calc(DirectedWeightedGraph<W> graph, Object from, AddableNumberSystem<W> ns);
}
