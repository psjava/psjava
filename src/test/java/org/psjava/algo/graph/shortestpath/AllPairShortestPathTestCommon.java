package org.psjava.algo.graph.shortestpath;

import org.junit.Assert;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.math.ns.IntegerNumberSystem;

abstract public class AllPairShortestPathTestCommon {

	private static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

	public static void testEmptyGraph(AllPairShortestPath algo) {
		int[][] edata = {};
		algo.calc(TestGraphFactory.create(edata), NS);
	}

	public static void testOneSize(AllPairShortestPath algo) {
		int[][] edata = { { 1, 1, 100 } };
		int actual = algo.calc(TestGraphFactory.create(edata), NS).getDistance(1, 1);
		Assert.assertEquals(0, actual);
	}

	public static void testNegativeEdgePath(AllPairShortestPath algo) {
		int[][] edata = { { 0, 1, 3 }, { 0, 2, 8 }, { 0, 4, -4 }, { 1, 3, 1 }, { 1, 4, 7 }, { 2, 1, 4 }, { 3, 0, 2 }, { 3, 2, -5 }, { 4, 3, 6 } };
		AllPairShortestPathResult<Integer, Integer> actual = algo.calc(TestGraphFactory.create(edata), NS);
		int[][] expected = { { 0, 1, -3, 2, -4 }, { 3, 0, -4, 1, -1 }, { 7, 4, 0, 5, 3 }, { 2, -1, -5, 0, -2 }, { 8, 5, 1, 6, 0 } };
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Assert.assertEquals(expected[i][j], (int) actual.getDistance(i, j));
				int tot = 0;
				for (DirectedWeightedEdge<Integer, Integer> e : actual.getPath(i, j))
					tot += e.weight();
				Assert.assertEquals(expected[i][j], tot);
			}
		}
	}

	public static void testNegativeCycle(AllPairShortestPath algo) {
		int[][] edata = { { 0, 1, -100 }, { 1, 0, -100 } };
		algo.calc(TestGraphFactory.create(edata), NS);
	}

}
