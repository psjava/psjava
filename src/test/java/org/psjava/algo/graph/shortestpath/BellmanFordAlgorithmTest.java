package org.psjava.algo.graph.shortestpath;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedOldGraph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class BellmanFordAlgorithmTest {

	@Test
	public void testSizeOneGraph() {
		SingleSourceShortestPathTestCommon.testSizeOneGraph(getInstance());
	}

	@Test
	public void testNotReachableVertex() {
		SingleSourceShortestPathTestCommon.testNotReachableVertex(getInstance());
	}

	@Test
	public void testCLRSExample() {
		SingleSourceShortestPathTestCommon.testCLRSExample(getInstance());
	}

	@Test
	public void testCalcEdgePath() {
		SingleSourceShortestPathTestCommon.testCalcEdgePath(getInstance());
	}

	@Test
	public void testNegativeEdgeGraph() {
		MutableDirectedWeightedOldGraph<Integer, Integer> g = MutableDirectedWeightedOldGraph.create();
		g.insertVertex(1);
		g.insertVertex(2);
		g.insertVertex(3);
		g.addEdge(1, 2, -20);
		g.addEdge(1, 3, 10);
		g.addEdge(2, 3, 20);
		SingleSourceShortestPathResult<Integer, Integer, DirectedWeightedEdge<Integer, Integer>> r = getInstance().calc(g, 1, IntegerNumberSystem.getInstance());
		Assert.assertEquals(0, (int) r.getDistance(3));
	}

	@Test(expected = RuntimeException.class)
	public void testNegativeCycle() {
		MutableDirectedWeightedOldGraph<Integer, Integer> g = TestGraphFactory.createDirectedWeighted(new int[][]{{1, 1, -100}});
		getInstance().calc(g, 1, IntegerNumberSystem.getInstance());
	}

	private BellmanFordAlgorithm getInstance() {
		return BellmanFordAlgorithm.getInstance();
	}

}
