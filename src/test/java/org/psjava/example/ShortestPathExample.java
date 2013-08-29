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

		SingleSourceShortestPath algorithm1 = GoodSingleSourceShortestPath.getInstance();
		SingleSourceShortestPathResult<Integer> result1 = algorithm1.calc(graph, "A", IntegerNumberSystem.getInstance());

		int a2c = result1.getDistance("C");
		boolean reachableOfD = result1.isReachable("D");

		assertEquals(30, a2c);
		assertFalse(reachableOfD);

		// The good one should be Dijkstra's Algorithm with binary heap. but you
		// can specify to another algorithm. Followings are some possibles.

		new Dijkstra(new BinaryHeapFactory());
		new BellmanFord(); // Capable for negative edge.

		// Let's get the shortest paths of all pairs. Floyd Warshall's algorithm is the simplest implementation.

		AllPairShortestPath algoritm2 = new FloydWarshall();
		AllPairShortestPathResult<Integer> result2 = algoritm2.calc(graph, IntegerNumberSystem.getInstance());

		int a2b = result2.getDistance("A", "B");
		int b2a = result2.getDistance("B", "C");

		assertEquals(10, a2b);
		assertEquals(20, b2a);

		// There are other algorithms to get shortest paths of all pairs.

		new FloydWarshall(); // Simplest.
		new Johnson(new BellmanFord(), new Dijkstra(new BinaryHeapFactory())); // Good for spase tree. Also capable in negative edges.

	}
}
