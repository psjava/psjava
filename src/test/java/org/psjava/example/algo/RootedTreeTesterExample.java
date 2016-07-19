package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.RootedTreeTester;
import org.psjava.ds.graph.MutableDirectedUnweightedGraph;

/**
 * @implementation {@link org.psjava.algo.graph.RootedTreeTester}
 * @see {@link CycleDetectionExample}
 */
public class RootedTreeTesterExample {

    @Test
    public void example() {
        MutableDirectedUnweightedGraph<String> tree = MutableDirectedUnweightedGraph.create();
        tree.insertVertex("A");
        tree.insertVertex("B");
        tree.insertVertex("C");

        tree.addEdge("A", "B");
        tree.addEdge("A", "C");

        boolean result1 = RootedTreeTester.is(tree, "A"); // must be true
        Assert.assertTrue(result1);

        MutableDirectedUnweightedGraph<String> cycled = MutableDirectedUnweightedGraph.create();
        cycled.insertVertex("A");
        cycled.insertVertex("B");

        cycled.addEdge("A", "B");
        cycled.addEdge("B", "A");

        boolean result2 = RootedTreeTester.is(cycled, "A"); // must be false
        Assert.assertFalse(result2);

    }
}
