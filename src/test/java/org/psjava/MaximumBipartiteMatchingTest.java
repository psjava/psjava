package org.psjava;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class MaximumBipartiteMatchingTest {
    @Test
    public void testCLRS() {
        BipartiteGraph<Integer> g = new BipartiteGraph<>();
        int[][] d = {{0, 5}, {1, 5}, {1, 7}, {2, 6}, {2, 7}, {2, 8}, {3, 7}, {4, 7}};
        for (int[] subd : d) {
            g.addLeft(subd[0]);
            g.addRight(subd[1]);
            g.addEdge(subd[0], subd[1]);
        }
        MaximumBipartiteMatchingResult<Integer> res = MaximumBipartiteMatching.calculate(g);
        Assert.assertEquals(3, res.getCount());

        List<String> matches = g.getLeftVertices().stream().flatMap(left ->
                g.getRightVertices().stream()
                        .filter(right -> res.isMatch(left, right))
                        .map(right -> left + ":" + right)
        ).collect(Collectors.toList());

        Assert.assertEquals("[0:5, 1:7, 2:6]", matches.toString());
    }

}
