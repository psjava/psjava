package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.graph.FlowNetworkEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class Residual {
    public static <F> F calc(FlowNetworkEdge<?, F, ?> e, AddableNumberSystem<F> ns) {
        return ns.subtract(e.getFlowStatus().capacity, e.getFlowStatus().flow);
    }

    private Residual() {
    }
}
