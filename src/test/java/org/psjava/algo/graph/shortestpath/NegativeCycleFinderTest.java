package org.psjava.algo.graph.shortestpath;

import org.junit.Test;
import org.psjava.ds.SimpleDirectedWeightedEdge;
import org.psjava.ds.graph.SimpleDirectedWeightedGraph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.util.IterableToString;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NegativeCycleFinderTest {

    @Test
    public void testNegativeCycleV2() {
        int[][] data = {{1, 2, 1}, {2, 3, -4}, {3, 4, 1}, {4, 2, 1}};
        SimpleDirectedWeightedGraph<Integer, Integer> g = TestGraphFactory.createDirectedWeightedNewV2(data);
        NegativeCycleFinderResult<SimpleDirectedWeightedEdge<Integer, Integer>> r = NegativeCycleFinder.find(g, g.getWeightFunction(), IntegerNumberSystem.getInstance());
        assertTrue(r.hasCycle());
        assertEquals("(3->4(1),4->2(1),2->3(-4))", IterableToString.toString(r.getPath()));
    }

    @Test
    public void testSizeOne() {
        int[][] data = {{1, 1, -1}};
        SimpleDirectedWeightedGraph<Integer, Integer> g = TestGraphFactory.createDirectedWeightedNewV2(data);
        NegativeCycleFinderResult<SimpleDirectedWeightedEdge<Integer, Integer>> r = NegativeCycleFinder.find(g, g.getWeightFunction(), IntegerNumberSystem.getInstance());
        assertTrue(r.hasCycle());
        assertEquals("(1->1(-1))", IterableToString.toString(r.getPath()));
    }

}
