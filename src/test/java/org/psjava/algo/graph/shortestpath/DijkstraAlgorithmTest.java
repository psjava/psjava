package org.psjava.algo.graph.shortestpath;

import org.junit.Test;
import org.psjava.algo.DijkstraAlgorithm;
import org.psjava.algo.SingleSourceShortestPathAlgorithm;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.goods.GoodMutableMapFactory;

public class DijkstraAlgorithmTest {

    private static final SingleSourceShortestPathAlgorithm INSTANCE = DijkstraAlgorithm.getInstance(BinaryHeapFactory.getInstance(), GoodMutableMapFactory.getInstance());

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

}
