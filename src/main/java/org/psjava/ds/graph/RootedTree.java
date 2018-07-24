package org.psjava.ds.graph;

import org.psjava.algo.graph.RootedTreeTester;
import org.psjava.util.Assertion;

public class RootedTree<V, E extends DirectedEdge<V>> {

    public static <V, E extends DirectedEdge<V>> RootedTree<V, E> wrap(Graph<V, E> g, V root) {
        return new RootedTree<V, E>(g, root);
    }

    public final Graph<V, E> graph;
    public final V root;

    public RootedTree(Graph<V, E> g, V root) {
        Assertion.ensure(RootedTreeTester.is(g, root), "Given graph is not a rooted tree");
        this.graph = g;
        this.root = root;
    }

}
