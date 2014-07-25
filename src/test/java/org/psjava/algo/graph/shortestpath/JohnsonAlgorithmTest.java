package org.psjava.algo.graph.shortestpath;

import org.junit.Test;
import org.psjava.goods.GoodDijkstraAlgorithm;

public class JohnsonAlgorithmTest {

	private static final JohnsonAlgorithm ALGO = new JohnsonAlgorithm(new BellmanFordAlgorithm(), GoodDijkstraAlgorithm.getInstance());

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