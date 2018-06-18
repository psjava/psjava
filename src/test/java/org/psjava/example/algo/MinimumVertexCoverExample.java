package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.MinimumVertexCover;
import org.psjava.BipartiteGraph;

/**
 * @implementation {@link org.psjava.MinimumVertexCover}
 * @see {@link org.psjava.example.algo.MaximumBipartiteMatchingExample}
 * @see {@link org.psjava.example.algo.MinimumVertexCoverInBipartiteGraphExample}
 */
public class MinimumVertexCoverExample {

    @Test
    public void example() {
        BipartiteGraph<String> g = new BipartiteGraph<>();

        g.addLeft("A");
        g.addLeft("B");
        g.addLeft("C");

        g.addRight("X");
        g.addRight("Y");
        g.addRight("Z");

        g.addEdge("A", "X");
        g.addEdge("A", "Y");
        g.addEdge("A", "Z");
        g.addEdge("B", "Z");
        g.addEdge("C", "Z");

        // By Konig's Theorem, In any bipartite graph, the number of edges in a maximum matching equals the number of vertices in a minimum vertex cover.
        // So matching algorithm is used in its implementation. In this example, Hopcroft-Karp algorithm is used.

        int number = MinimumVertexCover.calculate(g); // result is 2, ("A", "C")
        Assert.assertEquals(2, number);
    }

}
