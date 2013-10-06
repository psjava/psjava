package org.psjava.example;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.dfs.AllSourceDFS;
import org.psjava.algo.graph.dfs.DFSVisitor;
import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.MultiSourceDFS;
import org.psjava.algo.graph.dfs.SingleSourceDFS;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.MutableDirectedGraph;
import org.psjava.javautil.DataKeeper;
import org.psjava.javautil.VarargsIterable;

public class DFSExample {

	@Test
	public void example() {

		MutableDirectedGraph<String> g = MutableDirectedGraph.create();
		g.insertVertex("A");
		g.insertVertex("B");
		g.insertVertex("C");
		g.insertVertex("D");

		g.addEdge("A", "B");
		g.addEdge("B", "C");
		g.addEdge("C", "D");
		g.addEdge("C", "A");

		// Use Visitor for receiving visiting events.
		// Here we will find the back-edge

		final DataKeeper<String> backEdgeSource = DataKeeper.create("");

		SingleSourceDFS.traverse(g, "A", new DFSVisitor<String, DirectedEdge<String>>() {
			@Override
			public void onDiscovered(String vertex, int depth) {
			}

			@Override
			public void onWalkDown(DirectedEdge<String> edge) {
			}

			@Override
			public void onBackEdgeFound(DirectedEdge<String> edge) {
				backEdgeSource.set(edge.from());
			}

			@Override
			public void onFinish(String vertex, int depth) {
			}

			@Override
			public void onWalkUp(DirectedEdge<String> downedEdge) {
			}
		});

		// Here, We found that C->A is back-edge.

		Assert.assertEquals("C", backEdgeSource.get());

		// You can do multi sourced DFS. followings are the examples.

		MultiSourceDFS.traverse(g, VarargsIterable.create("A", "B"), new DFSVisitorBase<String, DirectedEdge<String>>());
		AllSourceDFS.traverse(g, new DFSVisitorBase<String, DirectedEdge<String>>());
	}
}
