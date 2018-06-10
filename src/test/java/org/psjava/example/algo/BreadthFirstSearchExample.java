package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.bfs.BFS;
import org.psjava.algo.graph.bfs.BFSVisitor;
import org.psjava.ds.PSCollection;
import org.psjava.ds.graph.MutableDirectedUnweightedGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.util.SingleElementCollection;
import org.psjava.util.VisitorStopper;

/**
 * @implementation {@link BFS}
 * @see {@link DepthFirstSearchExample}
 */
public class BreadthFirstSearchExample {

    @Test
    public void example() {
        // Let's prepare a simple graph.

        MutableDirectedUnweightedGraph<String> g = MutableDirectedUnweightedGraph.create();
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");

        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("C", "D");
        g.addEdge("B", "D");

        // Then find a path from "A" to "D" by BFS.

        PSCollection<String> starts = SingleElementCollection.create("A"); // You can specify multiple vertices. But here is one start vertex.

        BFS.traverse(g, starts, new BFSVisitor<String, DirectedEdge<String>>() {
            @Override
            public void onDiscover(String vertex, int depth, VisitorStopper stopper) {
                if (vertex.equals("D")) {
                    // There is a path: A->B->D, so depth is 2.
                    int pathLength = depth;
                    Assert.assertEquals(2, pathLength);
                    // when you call the stopper, BFS stops. So no other vertex will be discovered.
                    stopper.stop();
                }
            }

            @Override
            public void onWalk(DirectedEdge<String> e) {
                // You can also track the sequence of discovering edges.
            }
        });

    }

}
