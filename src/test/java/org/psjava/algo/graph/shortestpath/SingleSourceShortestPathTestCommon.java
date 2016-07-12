package org.psjava.algo.graph.shortestpath;

import org.junit.Assert;
import org.psjava.algo.SingleSourceShortestPathAlgorithm;
import org.psjava.ds.graph.SimpleDirectedWeightedGraph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class SingleSourceShortestPathTestCommon {

    private static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

    public static void testSizeOneGraph(SingleSourceShortestPathAlgorithm algo) {
        int[][] data = {{0, 0, 100}};
        SimpleDirectedWeightedGraph<Integer, Integer> g = createGraph(data);
        Assert.assertEquals("({0=0},{})", algo.calc(g, g.getWeightFunction(), 0, NS).toString());
    }

    public static void testNotReachableVertex(SingleSourceShortestPathAlgorithm algo) {
        int[][] data = {{0, 1, 100}, {2, 3, 200}};
        SimpleDirectedWeightedGraph<Integer, Integer> g = createGraph(data);
        Assert.assertEquals("({0=0, 1=100, 2=INF, 3=INF},{1=0->1(100)})", algo.calc(g, g.getWeightFunction(), 0, NS).toString());
    }

    public static void testCLRSExample(SingleSourceShortestPathAlgorithm algo) {
        int[][] data = {{0, 1, 3}, {0, 2, 5}, {1, 2, 2}, {1, 3, 6}, {2, 1, 1}, {2, 3, 4}, {2, 4, 6}, {3, 4, 2}, {4, 3, 7}, {4, 0, 3}};
        SimpleDirectedWeightedGraph<Integer, Integer> g = createGraph(data);
        Assert.assertEquals("({0=0, 1=3, 2=5, 3=9, 4=11},{1=0->1(3), 2=0->2(5), 3=1->3(6), 4=2->4(6)})", algo.calc(g, g.getWeightFunction(), 0, NS).toString());
    }

    public static SimpleDirectedWeightedGraph<Integer, Integer> createGraph(int[][] edgeData) {
        return TestGraphFactory.createDirectedWeightedNewV2(edgeData);
    }

}
