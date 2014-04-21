package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.LowestCommonAncestor;
import org.psjava.algo.graph.LowestCommonAncestorPreprecessed;
import org.psjava.ds.graph.DirectedEdge;
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
		MutableDirectedGraph<String> graph = MutableDirectedGraph.create();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");

		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("C", "D");

		RootedTree<String, DirectedEdge<String>> tree = RootedTree.create(graph, "A");

		LowestCommonAncestorPreprecessed<String> preprocessed = GoodLowestCommonAncestor.getInstrance().calc(tree);

		String result1 = preprocessed.query("B", "C"); // must be "A"
		Assert.assertEquals("A", result1);

		String result2 = preprocessed.query("A", "D"); // must be "A"
		Assert.assertEquals("A", result2);
	}
}
