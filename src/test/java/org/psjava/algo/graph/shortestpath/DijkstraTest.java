package org.psjava.algo.graph.shortestpath;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.ds.graph.AdjacencyListableDirectedWeightedGraphFactory;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.math.ns.IntegerNumberSystem;

public class DijkstraTest {

	private static final Dijkstra ALGO = new Dijkstra(new BinaryHeapFactory());

	@Test
	public void testNotReachableCompoment() {
		MutableDirectedWeightedGraph<Integer> g = new MutableDirectedWeightedGraph<Integer>();
		g.insertVertex("A");
		g.insertVertex("B");
		g.insertVertex("C");
		g.addEdge("B", "C", 1);
		SingleSourceShortestPathResult<Integer> r = ALGO.calc(AdjacencyListableDirectedWeightedGraphFactory.create(g), "A", IntegerNumberSystem.getInstance());
		Assert.assertFalse(r.isReachable("B"));
	}

}
