package org.psjava.ds.graph;

import org.psjava.algo.graph.RootedTreeTester;
import org.psjava.util.AssertStatus;

public class RootedTree<V, E extends DirectedEdge<V>> {

	public static <V, E extends DirectedEdge<V>> RootedTree<V, E> wrap(OldGraph<V, E> g, V root) {
		return new RootedTree<V, E>(g, root);
	}

	public final OldGraph<V, E> oldGraph;
	public final V root;

	public RootedTree(OldGraph<V, E> g, V root) {
		AssertStatus.assertTrue(RootedTreeTester.is(g, root), "Given graph is not a rooted tree");
		this.oldGraph = g;
		this.root = root;
	}

}
