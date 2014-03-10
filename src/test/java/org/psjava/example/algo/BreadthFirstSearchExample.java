package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.bfs.BFS;
import org.psjava.algo.graph.bfs.BFSVisitor;
import org.psjava.ds.Collection;
import org.psjava.ds.graph.AdjacencyListFromGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.MutableDirectedGraph;
import org.psjava.util.SingleElementCollection;
import org.psjava.util.VisitorStopper;

/**
 * @implementation {@link BFS}
 */
public class BreadthFirstSearchExample {

	@Test
	public void example() {
		// Let's prepare a simple graph.

		MutableDirectedGraph<String> g = MutableDirectedGraph.create();
		g.insertVertex("A");
		g.insertVertex("B");
		g.insertVertex("C");
		g.insertVertex("D");

		g.addEdge("A", "B");
		g.addEdge("B", "C");
		g.addEdge("C", "D");
		g.addEdge("B", "D");

		// Then find the "D" by BFS.

		Collection<String> starts = SingleElementCollection.create("A");
		BFS.traverse(AdjacencyListFromGraph.create(g), starts, new BFSVisitor<String, DirectedEdge<String>>() {
			@Override
			public void onDiscover(String vertex, int depth, VisitorStopper stopper) {
				if (vertex.equals("D")) {
					// There is a path : A->B->D, so depth is 2.
					int toD = depth;
					Assert.assertEquals(2, toD);
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
