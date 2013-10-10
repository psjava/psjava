package org.psjava.example;

import static org.junit.Assert.*;

import org.junit.Test;
import org.psjava.algo.graph.shortestpath.AllPairShortestPath;
import org.psjava.algo.graph.shortestpath.AllPairShortestPathResult;
import org.psjava.algo.graph.shortestpath.BellmanFord;
import org.psjava.algo.graph.shortestpath.Dijkstra;
import org.psjava.algo.graph.shortestpath.FloydWarshall;
import org.psjava.algo.graph.shortestpath.Johnson;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPath;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodSingleSourceShortestPath;

public class ShortestPathExample {

	@Test
	public void example() {

		// Let's construct a graph.

		MutableDirectedWeightedGraph<String, Integer> graph = MutableDirectedWeightedGraph.create();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.addEdge("A", "C", 100);
		graph.addEdge("A", "B", 10);
		graph.addEdge("B", "C", 20);

		// Then calculate distances from a single source - 'A'.
		// Choose algorithm, and do it.

		SingleSourceShortestPath algorithm1 = GoodSingleSourceShortestPath.getInstance();
		SingleSourceShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> result1 = algorithm1.calc(graph, "A", IntegerNumberSystem.getInstance());

		int distanceAToC = result1.getDistance("C");
		boolean reachabilityOfD = result1.isReachable("D");

		assertEquals(30, distanceAToC);
		assertFalse(reachabilityOfD);

		// The good one should be Dijkstra's Algorithm with binary heap. but you
		// can specify to another algorithm. Followings are some possibles.

		new Dijkstra(new BinaryHeapFactory());
		new BellmanFord(); // Capable for negative edge.

		// Let's get the shortest paths of all pairs. Floyd Warshall's algorithm is the simplest implementation.

		AllPairShortestPath algoritm2 = new FloydWarshall();
		AllPairShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> result2 = algoritm2.calc(graph, IntegerNumberSystem.getInstance());

		int distanceAToB = result2.getDistance("A", "B");
		int distanceBToC = result2.getDistance("B", "C");

		assertEquals(10, distanceAToB);
		assertEquals(20, distanceBToC);

		// There are other algorithms to get shortest paths of all pairs.

		new FloydWarshall(); // Simplest.
		new Johnson(new BellmanFord(), new Dijkstra(new BinaryHeapFactory())); // Good for spase tree. Also capable in negative edges.

	}
}
