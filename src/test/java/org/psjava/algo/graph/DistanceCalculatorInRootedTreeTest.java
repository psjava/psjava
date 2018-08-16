package org.psjava.algo.graph;

import org.junit.Test;
import org.psjava.ds.graph.RootedTree;
import org.psjava.ds.graph.SimpleDirectedWeightedGraph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodLowestCommonAncestorAlgorithm;
import org.psjava.goods.GoodMutableMapFactory;

import static org.junit.Assert.assertEquals;

public class DistanceCalculatorInRootedTreeTest {

    private static final DistanceCalculatorInRootedTree INSTANCE = new DistanceCalculatorInRootedTree(GoodLowestCommonAncestorAlgorithm.getInstrance(), GoodMutableMapFactory.getInstance());

    @Test
    public void testCalc() {
        Object[][] data = new Object[][]{{"A", "B", 100}, {"A", "C", 200}, {"B", "D", 400}, {"C", "E", 800}};
        SimpleDirectedWeightedGraph<String, Integer> graph = TestGraphFactory.createDirectedWeightedNewV2(data);
        DistanceCalculatorInRootedTreeResult<String, Integer> res = INSTANCE.calc(RootedTree.wrap(graph, "A"), graph.getWeightFunction(), IntegerNumberSystem.getInstance());
        assertEquals(0, (int) res.getDistance("A", "A"));
        assertEquals(1500, (int) res.getDistance("D", "E"));
        assertEquals(1500, (int) res.getDistance("E", "D"));
    }
}
