package org.psjava.algo.graph.dfs;

import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;

public class AllSourceDFS {

	/**
	 * Consider that visiting order is not fixed.
	 */
	public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> graph, DFSVisitor<V, E> visitor) {
		MultiSourceDFS.traverse(graph, graph.getVertices(), visitor);
	}

}
