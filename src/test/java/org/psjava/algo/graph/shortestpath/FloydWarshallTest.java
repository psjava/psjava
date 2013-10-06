package org.psjava.algo.graph.shortestpath;

import org.junit.Test;
import org.psjava.algo.graph.shortestpath.FloydWarshall;

public class FloydWarshallTest {

	private static final FloydWarshall ALGO = new FloydWarshall();

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
