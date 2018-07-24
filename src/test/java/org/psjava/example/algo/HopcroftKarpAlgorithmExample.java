package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.MaximumBipartiteMatching;
import org.psjava.BipartiteGraph;

/**
 * @implementation {@link MaximumBipartiteMatching}
 */
public class HopcroftKarpAlgorithmExample {

    @Test
    public void example() {

        // Let's make a simple bipartite graph.

        BipartiteGraph<String> g = new BipartiteGraph<>();

        g.addLeft("L1");
        g.addLeft("L2");
        g.addLeft("L3");
        g.addRight("R1");
        g.addRight("R2");

        g.addEdge("L1", "R1");
        g.addEdge("L1", "R2");
        g.addEdge("L2", "R1");
        g.addEdge("L3", "R1");

        // In this example, (L1-R2, L2-R1) is one of the solutions.

        int matchCount = MaximumBipartiteMatching.calculate(g).getCount(); // must be 2

        Assert.assertEquals(2, matchCount);
    }
}
