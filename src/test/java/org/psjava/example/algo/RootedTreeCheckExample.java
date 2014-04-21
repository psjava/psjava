package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.RootedTreeCheck;
import org.psjava.ds.graph.MutableDirectedGraph;

/**
 * @implementation {@link RootedTreeCheck}
 * @see {@link CycleDetectionExample}
 */
public class RootedTreeCheckExample {

	@Test
	public void example() {
		MutableDirectedGraph<String> tree = MutableDirectedGraph.create();
		tree.insertVertex("A");
		tree.insertVertex("B");
		tree.insertVertex("C");

		tree.addEdge("A", "B");
		tree.addEdge("A", "C");

		boolean result1 = RootedTreeCheck.is(tree, "A"); // must be true
		Assert.assertTrue(result1);

		MutableDirectedGraph<String> cycled = MutableDirectedGraph.create();
		cycled.insertVertex("A");
		cycled.insertVertex("B");

		cycled.addEdge("A", "B");
		cycled.addEdge("B", "A");

		boolean result2 = RootedTreeCheck.is(cycled, "A"); // must be false
		Assert.assertFalse(result2);

	}
}
