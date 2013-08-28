package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedGraph;
import org.psjava.math.ns.AddableNumberSystem;

public interface AllPairShortestPath {
	<W> AllPairShortestPathResult<W> calc(DirectedWeightedGraph<W> graph, AddableNumberSystem<W> ns);
}
