package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.SingleSourceShortestPathAlgorithm;
import org.psjava.algo.graph.shortestpath.AllPairShortestPathResult;
import org.psjava.algo.AllPairShortestPath;
import org.psjava.algo.graph.shortestpath.FloydWarshallAlgorithm;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.SimpleDirectedWeightedEdge;
import org.psjava.ds.graph.SimpleDirectedWeightedGraph;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodSingleSourceShortestPathAlgorithm;

/**
 * @see {@link DijkstraAlgorithmExample}
 * @see {@link BellmanFordAlgorithmExample}
 * @see {@link FloydWarshallAlgorithmExample}
 * @see {@link JohnsonAlgorithmExample}
 */
public class ShortestPathAlgorithmExample {

    @Test
    public void example() {

        // Let's construct a graph.

        SimpleDirectedWeightedGraph<String, Integer> graph = SimpleDirectedWeightedGraph.create();
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.addEdge("A", "C", 100);
        graph.addEdge("A", "B", 10);
        graph.addEdge("B", "C", 20);

        // Then calculate distances from a single source 'A'
        // Choose algorithm, and run it.

        SingleSourceShortestPathAlgorithm algorithm1 = GoodSingleSourceShortestPathAlgorithm.getInstance();
        SingleSourceShortestPathResult<String, Integer, SimpleDirectedWeightedEdge<String, Integer>> res1 = algorithm1.calc(graph, graph.getWeightFunction(), "A", IntegerNumberSystem.getInstance());

        int distanceAToC = res1.getDistance("C");
        boolean reachabilityOfD = res1.isReachable("D");

        // Let's get the shortest paths of all pairs. Floyd Warshall's algorithm is the simplest implementation.

        AllPairShortestPath algoritm2 = FloydWarshallAlgorithm.INSTANCE;
        AllPairShortestPathResult<String, Integer, SimpleDirectedWeightedEdge<String, Integer>> res2 = algoritm2.calc(graph, graph.getWeightFunction(), IntegerNumberSystem.getInstance());

        int distanceAToB = res2.getDistance("A", "B");
        int distanceBToC = res2.getDistance("B", "C");

        Assert.assertEquals(30, distanceAToC);
        Assert.assertFalse(reachabilityOfD);
        Assert.assertEquals(10, distanceAToB);
        Assert.assertEquals(20, distanceBToC);
    }
}
