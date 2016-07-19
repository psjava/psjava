package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.graph.FlowNetworkEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class FlowAdjustOnPath {

    public static <V, T> void adjust(Iterable<? extends FlowNetworkEdge<V, T, ?>> path, T add, AddableNumberSystem<T> ns) {
        for (FlowNetworkEdge<V, T, ?> e : path)
            FlowAdjust.adjust(e, add, ns);
    }

    private FlowAdjustOnPath() {
    }

}
