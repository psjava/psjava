package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.bfs.BFS;
import org.psjava.algo.graph.bfs.BFSVisitor;
import org.psjava.ds.graph.AdjacencyListFromGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.MutableDirectedGraph;
import org.psjava.util.SingleElementCollection;
import org.psjava.util.VisitorStopper;

public class BFSExample {

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
		g.addEdge("B", "D");

		// Let's find the D.

		BFS.traverse(AdjacencyListFromGraph.create(g), SingleElementCollection.create("A"), new BFSVisitor<String, DirectedEdge<String>>() {
			@Override
			public void onDiscover(String vertex, int depth, VisitorStopper stopper) {
				if (vertex.equals("D")) {
					// the depth is 2, because there is a path : A->B->D
					Assert.assertEquals(2, depth);

					// when you call the stopper, BFS stops. So no other vertex will be discovered.
					stopper.stop();
				}
			}

			@Override
			public void onWalk(DirectedEdge<String> e) {
				// You can also track the edges if you need.
			}
		});

	}

}
