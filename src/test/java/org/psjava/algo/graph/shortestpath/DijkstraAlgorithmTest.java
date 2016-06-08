package org.psjava.algo.graph.shortestpath;

import org.junit.Test;
import org.psjava.algo.DijkstraAlgorithmV2;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.goods.GoodMutableMapFactory;

public class DijkstraAlgorithmTest {

    private static final SingleSourceShortestPathAlgorithm ALGO = SingleSourceShortestPathAlgorithmUsingV2.wrap(DijkstraAlgorithmV2.getInstance(BinaryHeapFactory.getInstance(), GoodMutableMapFactory.getInstance()));

    @Test
    public void testSizeOneGraph() {
        SingleSourceShortestPathTestCommon.testSizeOneGraph(ALGO);
    }

    @Test
    public void testNotReachableVertex() {
        SingleSourceShortestPathTestCommon.testNotReachableVertex(ALGO);
    }

    @Test
    public void testCLRSExample() {
        SingleSourceShortestPathTestCommon.testCLRSExample(ALGO);
    }

    @Test
    public void testCalcEdgePath() {
        SingleSourceShortestPathTestCommon.testCalcEdgePath(ALGO);
    }

}
