package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedGraph;
import org.psjava.math.ns.AddableNumberSystem;

public interface AllPairShortestPath {
	<V, W> AllPairShortestPathResult<V, W> calc(DirectedWeightedGraph<V, W> graph, AddableNumberSystem<W> ns);
}
