package org.psjava.algo.graph.mst;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.PSCollection;
import org.psjava.ds.graph.MutableUndirectedWeightedGraph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.ds.graph.UndirectedWeightedEdge;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

abstract public class MinimumSpanningTreeAlgorithmTestBase {

    protected abstract MinimumSpanningTreeAlgorithm getInstance();

    @Test
    public void testEmpty() {
        Object[][] edata = {};
        assertResult(TestGraphFactory.createUndirectedWeightedNew(edata), 0);
    }

    @Test
    public void testVertex() {
        Object[][] edata = {{"A", "A", 10}};
        assertResult(TestGraphFactory.createUndirectedWeightedNew(edata), 0);
    }

    @Test
    public void testCLRSExample() {
        Object[][] edata = {{"0", "1", 4}, {"0", "2", 8}, {"1", "2", 11}, {"1", "4", 8}, {"2", "3", 7}, {"2", "5", 1}, {"3", "4", 2}, {"3", "5", 6}, {"4", "6", 7}, {"4", "7", 4}, {"5", "7", 2}, {"6", "7", 14}, {"6", "8", 9}, {"7", "8", 10}};
        assertResult(TestGraphFactory.createUndirectedWeightedNew(edata), 37);
    }

    private void assertResult(MutableUndirectedWeightedGraph<String, Integer> graph, int expectedTotal) {
        int total = 0;
        PSCollection<UndirectedWeightedEdge<String, Integer>> tree = getInstance().calc(graph, IntegerNumberSystem.getInstance());
        for (UndirectedWeightedEdge<String, Integer> e : tree)
            total += e.weight();
        Assert.assertEquals(expectedTotal, total);
    }

}
