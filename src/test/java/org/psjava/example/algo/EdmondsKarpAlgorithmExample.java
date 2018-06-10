package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.flownetwork.EdmondsKarpAlgorithm;
import org.psjava.algo.graph.flownetwork.FordFulkersonAlgorithm;
import org.psjava.algo.graph.flownetwork.MaximumFlowAlgorithmResult;
import org.psjava.ds.graph.CapacityEdge;
import org.psjava.ds.graph.MutableCapacityGraph;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

import java.util.function.Function;

/**
 * @implementation {@link EdmondsKarpAlgorithm}
 * @implementation {@link FordFulkersonAlgorithm}
 */
public class EdmondsKarpAlgorithmExample {
    @Test
    public void test() {
        // Construct a graph with capacities.

        MutableCapacityGraph<String, Integer> capacityGraph = MutableCapacityGraph.create();
        capacityGraph.insertVertex("A");
        capacityGraph.insertVertex("B");
        capacityGraph.insertVertex("C");
        capacityGraph.insertVertex("D");
        capacityGraph.addEdge("A", "B", 4);
        capacityGraph.addEdge("A", "C", 2);
        capacityGraph.addEdge("B", "C", 1);
        capacityGraph.addEdge("B", "D", 4);
        capacityGraph.addEdge("C", "D", 1);

        MaximumFlowAlgorithmResult<Integer, CapacityEdge<String, Integer>> result = EdmondsKarpAlgorithm.getInstance().calc(capacityGraph, "A", "D", IntegerNumberSystem.getInstance());

        // Maximum flow is 5.
        int flow = result.calcTotalFlow();

        // Also, you can obtain the flows in each edges by retrieved flow function.

        Function<CapacityEdge<String, Integer>, Integer> flowFunction = result.calcFlowFunction();
        for (CapacityEdge<String, Integer> e : capacityGraph.getEdges("A")) {
            flowFunction.apply(e);
        }

        Assert.assertEquals(5, flow);
    }
}
