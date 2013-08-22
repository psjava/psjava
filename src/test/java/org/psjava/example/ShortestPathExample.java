package org.psjava.example;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPath;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.DirectedWeightedEdgeFactory;
import org.psjava.ds.graph.MutableDirectedGraph;
import org.psjava.goods.GoodSingleSourceShortestPath;
import org.psjava.math.ns.IntegerNumberSystem;

public class ShortestPathExample {

	@Test
	public void example() {

		// construct graph.

		MutableDirectedGraph<DirectedWeightedEdge<Integer>> graph = new MutableDirectedGraph<DirectedWeightedEdge<Integer>>();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.addEdge(DirectedWeightedEdgeFactory.create("A", "C", 100));
		graph.addEdge(DirectedWeightedEdgeFactory.create("A", "B", 10));
		graph.addEdge(DirectedWeightedEdgeFactory.create("B", "C", 20));

		// Let's calculate distances from 'A', the single source.
		// Choose algorithm, and calculate. The good one should be dijkstra
		// algorithm with binary heap.

		SingleSourceShortestPath algo = GoodSingleSourceShortestPath.getInstance();
		SingleSourceShortestPathResult<Integer, DirectedWeightedEdge<Integer>> result = algo.calc(graph, "A", IntegerNumberSystem.getInstance());

		int distanceAToC = result.getDistance("C");

		Assert.assertEquals(30, distanceAToC);
	}
}
