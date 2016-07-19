package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.DijkstraAlgorithm;
import org.psjava.algo.SingleSourceShortestPathAlgorithm;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.SimpleDirectedWeightedEdge;
import org.psjava.ds.graph.SimpleDirectedWeightedGraph;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodDijkstraAlgorithm;

/**
 * @implementation {@link DijkstraAlgorithm}
 * @implementation {@link org.psjava.goods.GoodDijkstraAlgorithm}
 * @see {@link org.psjava.example.algo.ShortestPathAlgorithmExample}
 * @see {@link org.psjava.example.algo.BellmanFordAlgorithmExample}
 */
public class DijkstraAlgorithmExample {

    @Test
    public void example() {

        IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

        // Let's construct a simple graph.

        SimpleDirectedWeightedGraph<String, Integer> graph = SimpleDirectedWeightedGraph.create();
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.addEdge("A", "C", 100);
        graph.addEdge("A", "B", 10);
        graph.addEdge("B", "C", 20);

        // Calculate distances from a single source 'A'

        SingleSourceShortestPathAlgorithm dijkstra = GoodDijkstraAlgorithm.getInstance();
        SingleSourceShortestPathResult<String, Integer, SimpleDirectedWeightedEdge<String, Integer>> result = dijkstra.calc(graph, graph.getWeightFunction(), "A", NS);

        boolean reachabilityOfC = result.isReachable("C"); // C is reachable.
        boolean reachabilityOfD = result.isReachable("D"); // D is not reachable.
        int distanceToC = result.getDistance("C"); // must be 30

        Assert.assertTrue(reachabilityOfC);
        Assert.assertEquals(30, distanceToC);
        Assert.assertFalse(reachabilityOfD);
    }
}
