package org.psjava.algo.graph.matching;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.graph.MutableBipartiteGraph;

public abstract class MaximumBipartiteMatchingAlgorithmTestBase {
    @Test
    public void testCLRS() {
        MutableBipartiteGraph<Integer> g = new MutableBipartiteGraph<>();
        int[][] d = {{0, 5}, {1, 5}, {1, 7}, {2, 6}, {2, 7}, {2, 8}, {3, 7}, {4, 7}};
        for (int[] subd : d) {
            g.insertLeftVertex(subd[0]);
            g.insertRightVertex(subd[1]);
            g.addEdge(subd[0], subd[1]);
        }
        Assert.assertEquals(3, getInstance().calc(g));
    }

    protected abstract MaximumBipartiteMatchingAlgorithm getInstance();
}
