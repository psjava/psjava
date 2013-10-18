package org.psjava.example;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.dfs.AllSourceDFS;
import org.psjava.algo.graph.dfs.DFSVisitor;
import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.MultiSourceDFS;
import org.psjava.algo.graph.dfs.SingleSourceDFS;
import org.psjava.ds.graph.AdjacencyListFromGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.MutableDirectedGraph;
import org.psjava.util.DataKeeper;
import org.psjava.util.VarargsIterable;
import org.psjava.util.VisitorStopper;

public class DFSExample {

	@Test
	public void example() {

		MutableDirectedGraph<String> graph = MutableDirectedGraph.create();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");

		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		graph.addEdge("C", "A");

		// Use Visitor for receiving visiting events.
		// Here we will find the back-edge

		final DataKeeper<String> backEdgeSource = DataKeeper.create("");

		SingleSourceDFS.traverse(AdjacencyListFromGraph.create(graph), "A", new DFSVisitor<String, DirectedEdge<String>>() {
			@Override
			public void onDiscovered(String vertex, int depth, VisitorStopper stopper) {
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

		// We found that the edge:C->A is a back-edge.

		Assert.assertEquals("C", backEdgeSource.get());

		// You can do multi sourced DFS. followings are the examples.

		MultiSourceDFS.traverse(graph, VarargsIterable.create("A", "B"), new DFSVisitorBase<String, DirectedEdge<String>>());
		AllSourceDFS.traverse(graph, new DFSVisitorBase<String, DirectedEdge<String>>());
	}
}
