package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.LowestCommonAncestorQuerySession;
import org.psjava.ds.graph.MutableDirectedUnweightedGraph;
import org.psjava.ds.graph.RootedTree;
import org.psjava.example.ds.RootedTreeExample;
import org.psjava.goods.GoodLowestCommonAncestorAlgorithm;

/**
 * @implementation {@link org.psjava.algo.graph.LowestCommonAncestorAlgorithm}
 * @see {@link RootedTreeExample}
 */
public class LowestCommonAncestorExample {

    @Test
    public void example() {
        // Let's construct a simple rooted tree. A is the root.

        MutableDirectedUnweightedGraph<String> graph = MutableDirectedUnweightedGraph.create();
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("C", "D");

        // Run it!

        LowestCommonAncestorQuerySession<String> session = GoodLowestCommonAncestorAlgorithm.getInstrance().calc(RootedTree.wrap(graph, "A"));

        String result1 = session.query("B", "C"); // must be "A"
        Assert.assertEquals("A", result1);

        String result2 = session.query("A", "D"); // must be "A"
        Assert.assertEquals("A", result2);
    }
}
