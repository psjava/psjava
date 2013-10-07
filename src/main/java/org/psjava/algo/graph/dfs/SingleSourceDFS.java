package org.psjava.algo.graph.dfs;

import org.psjava.ds.graph.AdjacencyListFromGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.map.MutableMap;

public class SingleSourceDFS {
	public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> graph, V start, DFSVisitor<V, E> visitor) {
		MutableMap<V, DFSStatus> status = DFSCore.createInitialStatus(graph.getVertices());
		DFSCore.traverse(AdjacencyListFromGraph.create(graph), status, start, visitor);
	}
}
