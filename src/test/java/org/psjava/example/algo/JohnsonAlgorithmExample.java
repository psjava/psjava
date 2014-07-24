package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.shortestpath.AllPairShortestPath;
import org.psjava.algo.graph.shortestpath.AllPairShortestPathResult;
import org.psjava.algo.graph.shortestpath.BellmanFord;
import org.psjava.algo.graph.shortestpath.DijkstraAlgorithm;
import org.psjava.algo.graph.shortestpath.Johnson;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

/**
 * @implementation {@link Johnson}
 * @see {@link ShortestPathAlgorithmExample}
 */
public class JohnsonAlgorithmExample {

	@Test
	public void example() {

		// Let's construct a graph.

		MutableDirectedWeightedGraph<String, Integer> graph = MutableDirectedWeightedGraph.create();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.addEdge("A", "C", 10);
		graph.addEdge("A", "B", 15);
		graph.addEdge("B", "C", -10); // negative weight is allowed in Johnson's algorithm
		graph.addEdge("C", "A", 5);

		// Let's get the shortest paths of all pairs.
		// Johnson's algorithm is a combination of Bellman Ford's and Dijkstra's algorithm.

		AllPairShortestPath johnson = new Johnson(new BellmanFord(), new DijkstraAlgorithm(new BinaryHeapFactory()));
		AllPairShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> res = johnson.calc(graph, IntegerNumberSystem.getInstance());

		int distanceAToB = res.getDistance("A", "B"); // must be 15
		int distanceBToC = res.getDistance("B", "A"); // must be -5

		Assert.assertEquals(15, distanceAToB);
		Assert.assertEquals(-5, distanceBToC);
	}
}
