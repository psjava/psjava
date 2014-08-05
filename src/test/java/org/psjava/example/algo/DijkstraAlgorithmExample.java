package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.shortestpath.DijkstraAlgorithm;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedOldGraph;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodDijkstraAlgorithm;

/**
 * @implementation {@link DijkstraAlgorithm}
 * @implementation {@link GoodDijkstraAlgorithm}
 * @see {@link ShortestPathAlgorithmExample}
 * @see {@link BellmanFordAlgorithmExample}
 */
public class DijkstraAlgorithmExample {

	@Test
	public void example() {

		// Let's construct a simple graph.

		MutableDirectedWeightedOldGraph<String, Integer> graph = MutableDirectedWeightedOldGraph.create();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.addEdge("A", "C", 100);
		graph.addEdge("A", "B", 10);
		graph.addEdge("B", "C", 20);

		// Calculate distances from a single source 'A'

		DijkstraAlgorithm dijkstra = GoodDijkstraAlgorithm.getInstance();
		SingleSourceShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> result = dijkstra.calc(graph, "A", IntegerNumberSystem.getInstance());

		boolean reachabilityOfC = result.isReachable("C"); // C is reachable.
		boolean reachabilityOfD = result.isReachable("D"); // D is not reachable.
		int distanceToC = result.getDistance("C"); // must be 30

		Assert.assertTrue(reachabilityOfC);
		Assert.assertEquals(30, distanceToC);
		Assert.assertFalse(reachabilityOfD);
	}
}
