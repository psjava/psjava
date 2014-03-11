package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.shortestpath.Dijkstra;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPath;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

/**
 * @implementation {@link Dijkstra}
 * @see {@link ShortestPathExample}
 */
public class DijkstraAlgorithmExample {

	@Test
	public void example() {

		// Let's construct a simple graph.

		MutableDirectedWeightedGraph<String, Integer> graph = MutableDirectedWeightedGraph.create();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.addEdge("A", "C", 100);
		graph.addEdge("A", "B", 10);
		graph.addEdge("B", "C", 20);

		// Then calculate distances from a single source 'A'

		SingleSourceShortestPath dijkstra = new Dijkstra(new BinaryHeapFactory());
		SingleSourceShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> result1 = dijkstra.calc(graph, "A", IntegerNumberSystem.getInstance());

		boolean reachabilityOfC = result1.isReachable("C"); // must be true
		int distanceAToC = result1.getDistance("C"); // must be 30
		boolean reachabilityOfD = result1.isReachable("D"); // must be false

		Assert.assertTrue(reachabilityOfC);
		Assert.assertEquals(30, distanceAToC);
		Assert.assertFalse(reachabilityOfD);
	}
}
