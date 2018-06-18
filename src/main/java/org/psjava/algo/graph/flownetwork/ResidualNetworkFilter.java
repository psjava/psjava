package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.graph.FlowNetworkEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

import java.util.function.Predicate;

public class ResidualNetworkFilter {

    public static <F, E extends FlowNetworkEdge<?, F, ?>> Predicate<E> create(final AddableNumberSystem<F> ns) {
        return v -> ns.isPositive(Residual.calc(v, ns));
    }
}
