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
 * @see {@link ShortestPathAlgorithmExample}
 * @see {@link BellmanFordAlgorithmExample}
 */
public class DijkstraAlgorithmExample {

	@Test
	public void example() {

		// Dijkstra's algorithm is awesome... Let's construct a simple graph.

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
		SingleSourceShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> res = dijkstra.calc(graph, "A", IntegerNumberSystem.getInstance());

		boolean reachabilityOfC = res.isReachable("C"); // must be true
		boolean reachabilityOfD = res.isReachable("D"); // must be false
		int distanceToC = res.getDistance("C"); // must be 30

		Assert.assertTrue(reachabilityOfC);
		Assert.assertEquals(30, distanceToC);
		Assert.assertFalse(reachabilityOfD);
	}
}
