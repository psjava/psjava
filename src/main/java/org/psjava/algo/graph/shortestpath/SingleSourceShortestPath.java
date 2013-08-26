package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.AdjacencyListableDirectedWeightedGraph;
import org.psjava.math.ns.AddableNumberSystem;

public interface SingleSourceShortestPath {
	<W> SingleSourceShortestPathResult<W> calc(AdjacencyListableDirectedWeightedGraph<W> graph, Object from, AddableNumberSystem<W> ns);
}
