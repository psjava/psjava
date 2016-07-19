package org.psjava.algo.graph.flownetwork;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.graph.CapacityEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

abstract public class MaximumFlowAlgorithmTestBase {

    private static final IntegerNumberSystem NS2 = IntegerNumberSystem.getInstance();
    private MaximumFlowAlgorithm algorithm;

    public MaximumFlowAlgorithmTestBase(MaximumFlowAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Test
    public void testCLRS() {
        Object[][] data = {{"0", "1", 16}, {"0", "2", 13}, {"1", "2", 10}, {"1", "3", 12}, {"2", "1", 4}, {"2", "4", 14}, {"3", "2", 9}, {"3", "5", 20}, {"4", "3", 7}, {"4", "5", 4}};
        Graph<String, CapacityEdge<String, Integer>> g = TestGraphFactory.createCapacityGraphNew(data);
        Assert.assertEquals(23, (int) algorithm.calc(g, "0", "5", NS2).calcTotalFlow());
    }

}
