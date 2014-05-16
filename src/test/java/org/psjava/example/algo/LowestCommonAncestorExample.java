package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.LowestCommonAncestor;
import org.psjava.algo.graph.LowestCommonAncestorPreprecessed;
import org.psjava.ds.graph.MutableDirectedGraph;
import org.psjava.ds.graph.RootedTree;
import org.psjava.example.ds.RootedTreeExample;
import org.psjava.goods.GoodLowestCommonAncestor;

/**
 * @implementation {@link LowestCommonAncestor}
 * @see {@link RootedTreeExample}
 */
public class LowestCommonAncestorExample {

	@Test
	public void example() {
		// Let's construct a simple rooted tree. A is the root.

		MutableDirectedGraph<String> graph = MutableDirectedGraph.create();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");

		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("C", "D");

		// Run it!

		LowestCommonAncestorPreprecessed<String> result = GoodLowestCommonAncestor.getInstrance().calc(RootedTree.create(graph, "A"));

		String result1 = result.query("B", "C"); // must be "A"
		Assert.assertEquals("A", result1);

		String result2 = result.query("A", "D"); // must be "A"
		Assert.assertEquals("A", result2);
	}
}
