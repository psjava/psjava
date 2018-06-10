package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.mst.MinimumSpanningTreeAlgorithm;
import org.psjava.algo.graph.mst.PrimAlgorithm;
import org.psjava.ds.PSCollection;
import org.psjava.ds.graph.MutableUndirectedWeightedGraph;
import org.psjava.ds.graph.UndirectedWeightedEdge;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodMutableMapFactory;

/**
 * @implementation {@link PrimAlgorithm}
 * @see {@link MinimumSpanningTreeAlgorithmExample}
 */
public class PrimAlgorithmExample {

    @Test
    public void example() {
        MutableUndirectedWeightedGraph<String, Integer> graph = MutableUndirectedWeightedGraph.create();
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.addEdge("A", "B", 100);
        graph.addEdge("A", "C", 10);
        graph.addEdge("B", "C", 20);

        MinimumSpanningTreeAlgorithm algorithm = PrimAlgorithm.getInstance(BinaryHeapFactory.getInstance(), GoodMutableMapFactory.getInstance());

        PSCollection<UndirectedWeightedEdge<String, Integer>> tree = algorithm.calc(graph, IntegerNumberSystem.getInstance());

        int sum = 0;
        for (UndirectedWeightedEdge<String, Integer> e : tree)
            sum += e.weight();

        // sum must be 10+20=30

        Assert.assertEquals(30, sum);
    }
}
