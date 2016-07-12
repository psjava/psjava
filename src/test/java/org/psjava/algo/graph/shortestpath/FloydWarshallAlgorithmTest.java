package org.psjava.algo.graph.shortestpath;

import org.junit.Test;

public class FloydWarshallAlgorithmTest {

    private static final AllPairShortestPathV2 ALGO = FloydWarshallAlgorithm.INSTANCE;

    @Test
    public void testEmptyGraph() {
        AllPairShortestPathTestCommon.testEmptyGraph(ALGO);
    }

    @Test
    public void testOneSize() {
        AllPairShortestPathTestCommon.testOneSize(ALGO);
    }

    @Test
    public void testNegativeEdgePath() {
        AllPairShortestPathTestCommon.testNegativeEdgePath(ALGO);
    }

    @Test(expected = RuntimeException.class)
    public void testNegativeCycle() {
        AllPairShortestPathTestCommon.testNegativeCycle(ALGO);
    }

}
