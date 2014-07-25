package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.shortestpath.AllPairShortestPath;
import org.psjava.algo.graph.shortestpath.AllPairShortestPathResult;
import org.psjava.algo.graph.shortestpath.FloydWarshallAlgorithm;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

/**
 * @implementation {@link FloydWarshallAlgorithm}
 * @see {@link ShortestPathAlgorithmExample}
 */
public class FloydWarshallAlgorithmExample {

	@Test
	public void example() {

		// Let's construct a graph.

		MutableDirectedWeightedGraph<String, Integer> graph = MutableDirectedWeightedGraph.create();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.addEdge("A", "C", 100);
		graph.addEdge("A", "B", 10);
		graph.addEdge("B", "C", 20);

		// Let's get the shortest paths of all pairs.

		AllPairShortestPath floyd = FloydWarshallAlgorithm.getInstance();
		AllPairShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> res = floyd.calc(graph, IntegerNumberSystem.getInstance());

		int distanceAToB = res.getDistance("A", "B"); // must be 10
		int distanceBToC = res.getDistance("B", "C"); // must be 20

		Assert.assertEquals(10, distanceAToB);
		Assert.assertEquals(20, distanceBToC);
	}
}
