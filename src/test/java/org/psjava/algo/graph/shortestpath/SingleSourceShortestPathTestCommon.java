package org.psjava.algo.graph.shortestpath;

import org.junit.Assert;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class SingleSourceShortestPathTestCommon {

	private static final int INF = 1000000000;
	private static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

	public static void testSizeOneGraph(SingleSourceShortestPathAlgorithm algo) {
		int[][] data = { { 0, 0, 100 } };
		int[] expected = { 0 };
		MutableDirectedWeightedGraph<Integer, Integer> g = createGraph(data);
		assertAllResult(expected, algo.calc(g, 0, NS));
	}

	public static void testNotReachableVertex(SingleSourceShortestPathAlgorithm algo) {
		int[][] data = { { 0, 1, 100 }, { 2, 3, 200 } };
		int[] expected = { 0, 100, INF, INF };
		MutableDirectedWeightedGraph<Integer, Integer> g = createGraph(data);
		assertAllResult(expected, algo.calc(g, 0, NS));
	}

	public static void testCLRSExample(SingleSourceShortestPathAlgorithm algo) {
		int[][] data = { { 0, 1, 3 }, { 0, 2, 5 }, { 1, 2, 2 }, { 1, 3, 6 }, { 2, 1, 1 }, { 2, 3, 4 }, { 2, 4, 6 }, { 3, 4, 2 }, { 4, 3, 7 }, { 4, 0, 3 } };
		int[] expected = { 0, 3, 5, 9, 11 };
		MutableDirectedWeightedGraph<Integer, Integer> g = createGraph(data);
		assertAllResult(expected, algo.calc(g, 0, NS));
	}

	public static void testCalcEdgePath(SingleSourceShortestPathAlgorithm algo) {
		int[][] data = { { 0, 1, 100 }, { 1, 2, 200 }, { 0, 2, 400 } };
		int[][] path = { { 0, 1, 100 }, { 1, 2, 200 } };
		MutableDirectedWeightedGraph<Integer, Integer> g = createGraph(data);
		SingleSourceShortestPathResult<Integer, Integer, DirectedWeightedEdge<Integer, Integer>> rr = algo.calc(g, 0, NS);
		Iterable<DirectedWeightedEdge<Integer, Integer>> edgePath = rr.getPath(2);
		int index = 0;
		for (DirectedWeightedEdge<Integer, Integer> e : edgePath) {
			Assert.assertEquals(path[index][0], (int) e.from());
			Assert.assertEquals(path[index][1], (int) e.to());
			Assert.assertEquals(path[index][2], (int) e.weight());
			index++;
		}
	}

	public static MutableDirectedWeightedGraph<Integer, Integer> createGraph(int[][] edgeData) {
		return TestGraphFactory.create(edgeData);
	}

	public static void assertAllResult(int[] expected, SingleSourceShortestPathResult<Integer, Integer, DirectedWeightedEdge<Integer, Integer>> actual) {
		for (int i = 0; i < expected.length; i++) {
			if (expected[i] == INF) {
				Assert.assertEquals(false, actual.isReachable(i));
			} else {
				Assert.assertEquals(true, actual.isReachable(i));
				Assert.assertEquals(expected[i], (int) actual.getDistance(i));
			}
		}
	}

}
