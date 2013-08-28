package org.psjava.example;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.graph.shortestpath.BellmanFord;
import org.psjava.algo.graph.shortestpath.Dijkstra;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPath;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.heap.BinaryHeapFactory;
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

		// Then calculate distances from a single source - 'A'.
		// Choose algorithm, and do it.

		SingleSourceShortestPath algorithm = GoodSingleSourceShortestPath.getInstance();
		SingleSourceShortestPathResult<Integer> result = algorithm.calc(graph, "A", IntegerNumberSystem.getInstance());

		int distanceAToC = result.getDistance("C");

		Assert.assertEquals(30, distanceAToC);

		// The good one should be Dijkstra's Algorithm with binary heap. but you
		// can specify to another algorithm. Followings are some possibles.

		new Dijkstra(new BinaryHeapFactory());
		new BellmanFord();
	}
}
