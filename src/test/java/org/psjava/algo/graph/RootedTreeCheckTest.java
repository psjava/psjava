package org.psjava.algo.graph;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.RootedTreeCheck;
import org.psjava.ds.graph.TestGraphFactory;

public class RootedTreeCheckTest {
	@Test
	public void testOk() {
		String[][] data = new String[][] { { "A", "B" }, { "B", "C" }, { "A", "D" } };
		Assert.assertTrue(RootedTreeCheck.is(TestGraphFactory.createDirected(data), "A"));
	}

	@Test
	public void testCycled() {
		String[][] data = new String[][] { { "A", "B" }, { "B", "A" } };
		Assert.assertFalse(RootedTreeCheck.is(TestGraphFactory.createDirected(data), "A"));
	}

	@Test
	public void testNotReachable() {
		String[][] data = new String[][] { { "A", "B" }, { "B", "A" }, { "C", "A" } };
		Assert.assertFalse(RootedTreeCheck.is(TestGraphFactory.createDirected(data), "A"));
	}
}
