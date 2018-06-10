package org.psjava.algo.graph.flownetwork;

import java.util.function.Function;

public interface MaximumFlowAlgorithmResult<F, E> {
    F calcTotalFlow();

    Function<E, F> calcFlowFunction();
}
