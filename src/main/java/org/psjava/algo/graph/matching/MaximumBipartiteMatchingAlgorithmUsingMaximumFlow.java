package org.psjava.algo.graph.matching;

import org.psjava.algo.graph.flownetwork.MaximumFlowAlgorithm;
import org.psjava.ds.graph.BipartiteGraph;
import org.psjava.ds.graph.BipartiteGraphEdge;
import org.psjava.ds.graph.CapacityEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.MutableCapacityGraph;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class MaximumBipartiteMatchingAlgorithmUsingMaximumFlow {

    private static final Object VIRTUAL_START = new Object();
    private static final Object VIRTUAL_END = new Object();

    public static MaximumBipartiteMatchingAlgorithm getInstance(final MaximumFlowAlgorithm maxFlow) {
        return new MaximumBipartiteMatchingAlgorithm() {
            @Override
            public <V> int calc(BipartiteGraph<V> graph) {
                Graph<Object, CapacityEdge<Object, Integer>> augmented = constructAugmentedCapacityGraph(graph);
                return maxFlow.calc(augmented, VIRTUAL_START, VIRTUAL_END, IntegerNumberSystem.getInstance()).calcTotalFlow();
            }
        };
    }

    private static <V> MutableCapacityGraph<Object, Integer> constructAugmentedCapacityGraph(BipartiteGraph<V> original) {
        MutableCapacityGraph<Object, Integer> augmented = MutableCapacityGraph.create();
        augmented.insertVertex(VIRTUAL_START);
        augmented.insertVertex(VIRTUAL_END);
        for (Object v : original.getLeftVertices()) {
            augmented.insertVertex(v);
            augmented.addEdge(VIRTUAL_START, v, 1);
        }
        for (Object v : original.getRightVertices()) {
            augmented.insertVertex(v);
            augmented.addEdge(v, VIRTUAL_END, 1);
        }
        for (BipartiteGraphEdge<V> e : original.getEdges())
            augmented.addEdge(e.left(), e.right(), 1);
        return augmented;
    }

}
