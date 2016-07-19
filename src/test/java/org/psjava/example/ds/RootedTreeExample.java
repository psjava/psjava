package org.psjava.example.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.MutableDirectedUnweightedGraph;
import org.psjava.ds.graph.RootedTree;

/**
 * @implementation {@link RootedTree}
 */
public class RootedTreeExample {

    @Test
    public void example() {
        MutableDirectedUnweightedGraph<String> graph = MutableDirectedUnweightedGraph.create();
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");

        // if the given graph is not satisfying restrictions of rooted tree, following will throw runtime exception.
        RootedTree<String, DirectedEdge<String>> tree = RootedTree.wrap(graph, "A");

        Assert.assertNotNull(tree);
    }
}
