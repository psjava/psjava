package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.graph.FlowNetworkEdge;
import org.psjava.ds.graph.FlowStatus;
import org.psjava.ds.numbersystrem.AddInvert;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class FlowAdjust {

    public static <V, T> void adjust(FlowNetworkEdge<V, T, ?> e, T addition, AddableNumberSystem<T> ns) {
        addToStatus(e.getFlowStatus(), addition, ns);
        addToStatus(e.getOpposite().getFlowStatus(), AddInvert.calc(ns, addition), ns);
    }

    private static <F> void addToStatus(FlowStatus<F> status, F addition, AddableNumberSystem<F> ns) {
        status.flow = ns.add(status.flow, addition);
    }

    private FlowAdjust() {
    }

}
