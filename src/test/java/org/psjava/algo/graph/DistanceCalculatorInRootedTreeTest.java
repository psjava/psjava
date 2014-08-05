package org.psjava.algo.graph;

import static org.junit.Assert.*;

import org.junit.Test;
import org.psjava.ds.graph.*;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodLowestCommonAncestorAlgorithm;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.goods.GoodSegmentTreeFactory;

public class DistanceCalculatorInRootedTreeTest {

	private static final DistanceCalculatorInRootedTree INSTANCE = new DistanceCalculatorInRootedTree(GoodLowestCommonAncestorAlgorithm.getInstrance(), GoodSegmentTreeFactory.getInstance(), GoodMutableMapFactory.getInstance());

	@Test
	public void testCalc() {
		Object[][] data = new Object[][] { { "A", "B", 100 }, { "A", "C", 200 }, { "B", "D", 400 }, { "C", "E", 800 } };
		MutableDirectedWeightedGraph<String, Integer> graph = TestGraphFactory.createDirectedWeightedNew(data);
		DistanceCalculatorInRootedTreeResult<String, Integer> res = INSTANCE.calc(RootedTree.wrap(graph, "A"), IntegerNumberSystem.getInstance());
		assertEquals(0, (int) res.getDistance("A", "A"));
		assertEquals(1500, (int) res.getDistance("D", "E"));
		assertEquals(1500, (int) res.getDistance("E", "D"));
	}
}
