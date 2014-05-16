package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.shortestpath.Dijkstra;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPath;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodDijkstra;

/**
 * @implementation {@link Dijkstra}
 * @see {@link ShortestPathAlgorithmExample}
 * @see {@link BellmanFordAlgorithmExample}
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

		// Calculate distances from a single source 'A'

		SingleSourceShortestPath dijkstra = GoodDijkstra.getInstance();
		SingleSourceShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> result = dijkstra.calc(graph, "A", IntegerNumberSystem.getInstance());

		boolean reachabilityOfC = result.isReachable("C"); // C is reachable.
		boolean reachabilityOfD = result.isReachable("D"); // D is not reachable.
		int distanceToC = result.getDistance("C"); // must be 30

		Assert.assertTrue(reachabilityOfC);
		Assert.assertEquals(30, distanceToC);
		Assert.assertFalse(reachabilityOfD);
	}
}
