package org.psjava.algo.graph;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.DijkstraAlgorithm;
import org.psjava.algo.SingleSourceShortestPathAlgorithm;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodMutableMapFactory;

public class DijkstraAlgorithmTest {

    private static final SingleSourceShortestPathAlgorithm ALGO = DijkstraAlgorithm.getInstance(BinaryHeapFactory.getInstance(), GoodMutableMapFactory.getInstance());

    @Test
    public void testSizeOneGraph() {
        MutableDirectedWeightedGraph<String, Integer> g = MutableDirectedWeightedGraph.create();
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");
        g.addEdge("A", "B", 10);
        g.addEdge("B", "C", 20);
        g.addEdge("A", "C", 40);

        SingleSourceShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> r = ALGO.calc(g, new Function<DirectedWeightedEdge<String, Integer>, Integer>() {
            @Override
            public Integer get(DirectedWeightedEdge<String, Integer> input) {
                return input.weight();
            }
        }, "A", IntegerNumberSystem.getInstance());

        Assert.assertEquals("({A=0, B=10, C=30, D=INF},{B=A->B(10), C=B->C(20)})", r.toString());
    }


}