package org.psjava.ds.graph;

import org.psjava.algo.graph.RootedTreeCheck;
import org.psjava.util.AssertStatus;

public class RootedTree<V, E extends DirectedEdge<V>> {

	public static <V, E extends DirectedEdge<V>> RootedTree<V, E> create(org.psjava.ds.graph.Graph<V, E> g, V root) {
		return new RootedTree<V, E>(g, root);
	}

	public final org.psjava.ds.graph.Graph<V, E> graph;
	public final V root;

	private RootedTree(org.psjava.ds.graph.Graph<V, E> g, V root) {
		AssertStatus.assertTrue(RootedTreeCheck.is(g, root), "Given graph is not a rooted tree");
		this.graph = g;
		this.root = root;
	}

}
