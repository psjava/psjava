package org.psjava.algo.graph.matching;

import org.psjava.algo.graph.flownetwork.MaximumFlowAlgorithm;
import org.psjava.algo.graph.flownetwork.MaximumFlowAlgorithmResult;
import org.psjava.ds.graph.AllEdgeInGraph;
import org.psjava.ds.graph.BipartiteGraph;
import org.psjava.ds.graph.BipartiteGraphEdge;
import org.psjava.ds.graph.CapacityEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.MutableCapacityGraph;
import org.psjava.ds.map.PSMap;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodMutableMapFactory;

public class MaximumBipartiteMatchingAlgorithmUsingMaximumFlow {

    private static final Object VIRTUAL_START = new Object();
    private static final Object VIRTUAl_END = new Object();

    public static MaximumBipartiteMatchingAlgorithm getInstance(final MaximumFlowAlgorithm maxFlow) {
        return new MaximumBipartiteMatchingAlgorithm() {
            @Override
            public <V> MaximumBipartiteMatchingResult<V> calc(BipartiteGraph<V> graph) {
                Graph<Object, CapacityEdge<Object, Integer>> augmented = constructAugmentedCapacityGraph(graph);
                MaximumFlowAlgorithmResult<Integer, CapacityEdge<Object, Integer>> maxFlowResult = maxFlow.calc(augmented, VIRTUAL_START, VIRTUAl_END, IntegerNumberSystem.getInstance());
                PSMap<V, V> matchMap = createMatchMapFromMaxFlowResult(augmented, maxFlowResult);
                return wrapResult(matchMap);
            }
        };
    }

    private static <V> MutableCapacityGraph<Object, Integer> constructAugmentedCapacityGraph(BipartiteGraph<V> original) {
        MutableCapacityGraph<Object, Integer> augmented = MutableCapacityGraph.create();
        augmented.insertVertex(VIRTUAL_START);
        augmented.insertVertex(VIRTUAl_END);
        for (Object v : original.getLeftVertices()) {
            augmented.insertVertex(v);
            augmented.addEdge(VIRTUAL_START, v, 1);
        }
        for (Object v : original.getRightVertices()) {
            augmented.insertVertex(v);
            augmented.addEdge(v, VIRTUAl_END, 1);
        }
        for (BipartiteGraphEdge<V> e : original.getEdges())
            augmented.addEdge(e.left(), e.right(), 1);
        return augmented;
    }

    private static <V> PSMap<V, V> createMatchMapFromMaxFlowResult(Graph<Object, CapacityEdge<Object, Integer>> augmented, MaximumFlowAlgorithmResult<Integer, CapacityEdge<Object, Integer>> maxFlowResult) {
        Function<CapacityEdge<Object, Integer>, Integer> flowFunction = maxFlowResult.calcFlowFunction();
        MutableMap<V, V> map = GoodMutableMapFactory.getInstance().create();
        for (CapacityEdge<Object, Integer> e : AllEdgeInGraph.wrap(augmented)) {
            if (flowFunction.get(e) == 1) {
                if (e.from() != VIRTUAL_START && e.to() != VIRTUAl_END) {
                    map.add((V) e.from(), (V) e.to());
                    map.add((V) e.to(), (V) e.from());
                }
            }
        }
        return map;
    }

    private static <V> MaximumBipartiteMatchingResult<V> wrapResult(final PSMap<V, V> matchMap) {
        return new MaximumBipartiteMatchingResult<V>() {
            @Override
            public V getMatchedVertex(V v) {
                return matchMap.get(v);
            }

            @Override
            public int getMaxMatchCount() {
                return matchMap.size() / 2;
            }

            @Override
            public boolean hasMatch(V from) {
                return matchMap.containsKey(from);
            }
        };
    }

}
