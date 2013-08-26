package org.psjava.example;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPath;
import org.psjava.ds.graph.AdjacencyListableDirectedWeightedGraphFactory;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.goods.GoodSingleSourceShortestPath;
import org.psjava.math.ns.IntegerNumberSystem;

public class ShortestPathExample {

	@Test
	public void example() {

		// Let's construct a graph.

		MutableDirectedWeightedGraph<Integer> graph = new MutableDirectedWeightedGraph<Integer>();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.addEdge("A", "C", 100);
		graph.addEdge("A", "B", 10);
		graph.addEdge("B", "C", 20);

		// Let's calculate distances from 'A', the single source.
		// Choose algorithm, and calculate. The good one should be dijkstra
		// algorithm with binary heap.

		SingleSourceShortestPath algo = GoodSingleSourceShortestPath.getInstance();
		SingleSourceShortestPathResult<Integer> result = algo.calc(AdjacencyListableDirectedWeightedGraphFactory.create(graph), "A", IntegerNumberSystem.getInstance());

		int distanceAToC = result.getDistance("C");

		Assert.assertEquals(30, distanceAToC);
	}
}
