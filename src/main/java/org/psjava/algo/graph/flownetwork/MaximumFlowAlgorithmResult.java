package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.math.Function;

public interface MaximumFlowAlgorithmResult<F, E> {
    F calcTotalFlow();

    Function<E, F> calcFlowFunction();
}
