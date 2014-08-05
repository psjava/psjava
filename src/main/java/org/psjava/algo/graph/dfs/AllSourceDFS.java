package org.psjava.algo.graph.dfs;

import org.psjava.ds.graph.NewGraphFromGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.OldGraph;

public class AllSourceDFS {

	/**
	 * Remember that visiting order is not ordered.
	 */
	public static <V, E extends DirectedEdge<V>> void traverse(OldGraph<V, E> oldGraph, DFSVisitor<V, E> visitor) {
		MultiSourceDFS.traverse(NewGraphFromGraph.createFromDirected(oldGraph), oldGraph.getVertices(), visitor);
	}

	private AllSourceDFS() {
	}

}
