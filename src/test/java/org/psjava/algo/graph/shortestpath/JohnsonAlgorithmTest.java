package org.psjava.algo.graph.shortestpath;

import org.junit.Test;
import org.psjava.ds.heap.BinaryHeapFactory;

public class JohnsonAlgorithmTest {

	private static final JohnsonAlgorithm ALGO = new JohnsonAlgorithm(new BellmanFordAlgorithm(), new DijkstraAlgorithm(new BinaryHeapFactory()));

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