package org.psjava;

import org.junit.Assert;
import org.junit.Test;

public class MaximumBipartiteMatchingTest {
    @Test
    public void testCLRS() {
        BipartiteGraph<Integer> g = new BipartiteGraph<>();
        int[][] d = {{0, 5}, {1, 5}, {1, 7}, {2, 6}, {2, 7}, {2, 8}, {3, 7}, {4, 7}};
        for (int[] subd : d) {
            g.insertLeftVertex(subd[0]);
            g.insertRightVertex(subd[1]);
            g.addEdge(subd[0], subd[1]);
        }
        Assert.assertEquals(3, MaximumBipartiteMatching.calculate(g));
    }

}
