package org.psjava.algo.graph.shortestpath;

import org.junit.Assert;
import org.psjava.algo.AllPairShortestPath;
import org.psjava.ds.SimpleDirectedWeightedEdge;
import org.psjava.ds.graph.SimpleDirectedWeightedGraph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

abstract public class AllPairShortestPathTestCommon {

    private static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

    public static void testEmptyGraph(AllPairShortestPath algo) {
        Object[][] edata = {};
        SimpleDirectedWeightedGraph<String, Integer> g = TestGraphFactory.createDirectedWeightedNewV2(edata);
        algo.calc(g, g.getWeightFunction(), NS);
    }

    public static void testOneSize(AllPairShortestPath algo) {
        Object[][] edata = {{"A", "A", 100}};
        SimpleDirectedWeightedGraph<String, Integer> g = TestGraphFactory.createDirectedWeightedNewV2(edata);
        int actual = algo.calc(g, g.getWeightFunction(), NS).getDistance("A", "A");
        Assert.assertEquals(0, actual);
    }

    public static void testNegativeEdgePath(AllPairShortestPath algo) {
        Object[][] edata = {{"A", "B", 3}, {"A", "C", 8}, {"A", "E", -4}, {"B", "D", 1}, {"B", "E", 7}, {"C", "B", 4}, {"D", "A", 2}, {"D", "C", -5}, {"E", "D", 6}};
        SimpleDirectedWeightedGraph<String, Integer> g = TestGraphFactory.createDirectedWeightedNewV2(edata);
        AllPairShortestPathResult<String, Integer, SimpleDirectedWeightedEdge<String, Integer>> actual = algo.calc(g, g.getWeightFunction(), NS);
        int[][] expected = {{0, 1, -3, 2, -4}, {3, 0, -4, 1, -1}, {7, 4, 0, 5, 3}, {2, -1, -5, 0, -2}, {8, 5, 1, 6, 0}};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Assert.assertEquals(expected[i][j], (int) actual.getDistance(toString(i), toString(j)));
                int tot = 0;
                for (SimpleDirectedWeightedEdge<String, Integer> e : actual.getPath(toString(i), toString(j)))
                    tot += g.getWeightFunction().apply(e);
                Assert.assertEquals(expected[i][j], tot);
            }
        }
    }

    private static String toString(int i) {
        return "" + (char) ('A' + i);
    }

    public static void testNegativeCycle(AllPairShortestPath algo) {
        Object[][] edata = {{"A", "B", -100}, {"B", "A", -100}};
        SimpleDirectedWeightedGraph<String, Integer> g = TestGraphFactory.createDirectedWeightedNewV2(edata);
        algo.calc(g, g.getWeightFunction(), NS);
    }

}
