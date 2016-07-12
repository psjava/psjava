package org.psjava.algo.graph.shortestpath;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.SingleSourceShortestPathAlgorithm;
import org.psjava.ds.graph.SimpleDirectedWeightedGraph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class BellmanFordAlgorithmTest {

    private static final SingleSourceShortestPathAlgorithm INSTANCE = BellmanFordAlgorithm.getInstance();

    @Test
    public void testSizeOneGraph() {
        SingleSourceShortestPathTestCommon.testSizeOneGraph(INSTANCE);
    }

    @Test
    public void testNotReachableVertex() {
        SingleSourceShortestPathTestCommon.testNotReachableVertex(INSTANCE);
    }

    @Test
    public void testCLRSExample() {
        SingleSourceShortestPathTestCommon.testCLRSExample(INSTANCE);
    }

    @Test
    public void testNegativeEdgeGraph() {
        SimpleDirectedWeightedGraph<Integer, Integer> g = TestGraphFactory.createDirectedWeightedNewV2(new int[][]{{1, 2, -20}, {1, 3, 10}, {2, 3, 20}});
        Assert.assertEquals("({1=0, 2=-20, 3=0},{2=1->2(-20), 3=2->3(20)})", INSTANCE.calc(g, g.getWeightFunction(), 1, IntegerNumberSystem.getInstance()).toString());
    }

    @Test(expected = RuntimeException.class)
    public void testNegativeCycle() {
        int[][] data = {{1, 1, -100}};
        SimpleDirectedWeightedGraph<Integer, Integer> g = TestGraphFactory.createDirectedWeightedNewV2(data);
        INSTANCE.calc(g, g.getWeightFunction(), 1, IntegerNumberSystem.getInstance());
    }

}
