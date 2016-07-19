package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.CycleDetection;
import org.psjava.ds.graph.MutableDirectedUnweightedGraph;

/**
 * @implementation {@link CycleDetection}
 * @see {@link DepthFirstSearchExample}
 */
public class CycleDetectionExample {

    @Test
    public void example() {
        // Let's prepare a simple graph.

        MutableDirectedUnweightedGraph<String> graph = MutableDirectedUnweightedGraph.create();
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "B");

        boolean hasCycle = CycleDetection.hasCycle(graph); // must be true
        Assert.assertTrue(hasCycle);

    }
}
