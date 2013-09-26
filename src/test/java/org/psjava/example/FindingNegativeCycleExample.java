package org.psjava.example;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.shortestpath.NegativeCycleFinder;
import org.psjava.ds.Collection;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.math.ns.IntegerNumberSystem;

public class FindingNegativeCycleExample {

	@Test
	public void test() {

		// Let's consturct a simple graph.

		MutableDirectedWeightedGraph<String, Integer> g = MutableDirectedWeightedGraph.create();
		g.insertVertex("A");
		g.insertVertex("B");
		g.insertVertex("C");
		g.addEdge("A", "B", 100);
		g.addEdge("B", "C", 200);
		g.addEdge("C", "A", -100);

		// Now, there is no negative cycles yet.

		boolean hasCycle = NegativeCycleFinder.find(g, IntegerNumberSystem.getInstance()).hasCycle();
		Assert.assertFalse(hasCycle);

		// Add another edge to create a negative cycle.

		g.addEdge("C", "A", -400);

		// this is the path!
		Collection<DirectedWeightedEdge<String, Integer>> path = NegativeCycleFinder.find(g, IntegerNumberSystem.getInstance()).getPath(); 
		Assert.assertEquals(3, path.size());
	}
}
