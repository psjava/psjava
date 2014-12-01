package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.shortestpath.DijkstraAlgorithm;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodDijkstraAlgorithm;

/**
 * @implementation {@link org.psjava.algo.graph.shortestpath.DijkstraAlgorithm}
 * @implementation {@link org.psjava.goods.GoodDijkstraAlgorithm}
 *
 * @see {@link org.psjava.example.algo.ShortestPathAlgorithmExample}
 * @see {@link org.psjava.example.algo.BellmanFordAlgorithmExample}
 */
public class DijkstraAlgorithmExample {

	@Test
	public void example() {

		IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

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

		DijkstraAlgorithm dijkstra = GoodDijkstraAlgorithm.getInstance();
		SingleSourceShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> result = dijkstra.calc(graph, "A", NS);

		boolean reachabilityOfC = result.isReachable("C"); // C is reachable.
		boolean reachabilityOfD = result.isReachable("D"); // D is not reachable.
		int distanceToC = result.getDistance("C"); // must be 30

		Assert.assertTrue(reachabilityOfC);
		Assert.assertEquals(30, distanceToC);
		Assert.assertFalse(reachabilityOfD);
	}
}
