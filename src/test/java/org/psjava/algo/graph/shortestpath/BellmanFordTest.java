package org.psjava.algo.graph.shortestpath;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.shortestpath.BellmanFord;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.math.ns.IntegerNumberSystem;

public class BellmanFordTest {

	@Test
	public void testSizeOneGraph() {
		SingleSourceShortestPathTestCommon.testSizeOneGraph(new BellmanFord());
	}

	@Test
	public void testNotReachableVertex() {
		SingleSourceShortestPathTestCommon.testNotReachableVertex(new BellmanFord());
	}

	@Test
	public void testCLRSExample() {
		SingleSourceShortestPathTestCommon.testCLRSExample(new BellmanFord());
	}

	@Test
	public void testCalcEdgePath() {
		SingleSourceShortestPathTestCommon.testCalcEdgePath(new BellmanFord());
	}

	@Test
	public void testNegativeEdgeGraph() {
		MutableDirectedWeightedGraph<Integer, Integer> g = MutableDirectedWeightedGraph.create();
		g.insertVertex(1);
		g.insertVertex(2);
		g.insertVertex(3);
		g.addEdge(1, 2, -20);
		g.addEdge(1, 3, 10);
		g.addEdge(2, 3, 20);
		SingleSourceShortestPathResult<Integer, Integer, DirectedWeightedEdge<Integer, Integer>> r = new BellmanFord().calc(g, 1, IntegerNumberSystem.getInstance());
		Assert.assertEquals(0, (int) r.getDistance(3));
	}

	@Test(expected = RuntimeException.class)
	public void testNegativeCycle() {
		MutableDirectedWeightedGraph<Integer, Integer> g = TestGraphFactory.create(new int[][] { { 1, 1, -100 } });
		new BellmanFord().calc(g, 1, IntegerNumberSystem.getInstance());
	}
}
