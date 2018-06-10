package org.psjava.algo.graph.flownetwork;

import org.psjava.algo.math.FunctionFromMap;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.FlowNetworkEdge;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.goods.GoodMutableMapFactory;

import java.util.function.Function;

public class MaximumFlowAlgorithmResultFactory {

    public static <V, F, E> MaximumFlowAlgorithmResult<F, E> create(final Graph<V, FlowNetworkEdge<V, F, E>> flowNetwork, final V start, final AddableNumberSystem<F> ns) {
        return new MaximumFlowAlgorithmResult<F, E>() {
            @Override
            public F calcTotalFlow() {
                F total = ns.getZero();
                for (FlowNetworkEdge<V, F, E> e : flowNetwork.getEdges(start))
                    total = ns.add(total, e.getFlowStatus().flow);
                return total;
            }

            @Override
            public Function<E, F> calcFlowFunction() {
                MutableMap<E, F> flow = GoodMutableMapFactory.getInstance().create();
                for (V v : flowNetwork.getVertices())
                    for (FlowNetworkEdge<V, F, E> e : flowNetwork.getEdges(v))
                        if (!e.isSkewSymmetryEdge())
                            flow.add(e.getOriginalCapacityEdge(), e.getFlowStatus().flow);
                return FunctionFromMap.wrap(flow);
            }
        };
    }

    private MaximumFlowAlgorithmResultFactory() {
    }

}
