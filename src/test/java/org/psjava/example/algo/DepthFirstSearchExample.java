package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.dfs.AllSourceDFS;
import org.psjava.algo.graph.dfs.DFSCore;
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

/**
 * @implementation {@link DFSCore}
 */
public class DepthFirstSearchExample {

	@Test
	public void example() {

		// Let's prepare a simple graph.

		MutableDirectedGraph<String> graph = MutableDirectedGraph.create();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");

		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		graph.addEdge("C", "A");

		// Use Visitor for handling searching events.
		// Here, we will find the back-edge in the graph.

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
				// Found!
				// the edge:C->A is a back-edge.
				backEdgeSource.set(edge.from());
			}

			@Override
			public void onFinish(String vertex, int depth) {
			}

			@Override
			public void onWalkUp(DirectedEdge<String> downedEdge) {
			}
		});

		// You can do multi-sources DFS. followings are the examples.

		Iterable<String> sources = VarargsIterable.create("A", "B");
		MultiSourceDFS.traverse(graph, sources, new DFSVisitorBase<String, DirectedEdge<String>>());
		AllSourceDFS.traverse(graph, new DFSVisitorBase<String, DirectedEdge<String>>());

		Assert.assertEquals("C", backEdgeSource.get());
	}
}
