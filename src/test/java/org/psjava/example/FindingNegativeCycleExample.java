package org.psjava.example;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.shortestpath.NegativeCycleFinder;
import org.psjava.algo.graph.shortestpath.NegativeCycleFinderResult;
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

		NegativeCycleFinderResult<String, Integer> result1 = NegativeCycleFinder.find(g, IntegerNumberSystem.getInstance());
		boolean has1 = result1.hasCycle();
		Assert.assertFalse(has1);

		// Add another edge to make a cycle.

		g.addEdge("C", "A", -400);

		NegativeCycleFinderResult<String, Integer> result2 = NegativeCycleFinder.find(g, IntegerNumberSystem.getInstance());
		boolean has2 = result2.hasCycle();
		Collection<DirectedWeightedEdge<String, Integer>> path = result2.getPath(); // this is the path!

		Assert.assertTrue(has2);
		Assert.assertEquals(3, path.size());
	}
}
