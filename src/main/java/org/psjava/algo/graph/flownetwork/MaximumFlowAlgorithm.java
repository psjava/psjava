package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.graph.CapacityEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public interface MaximumFlowAlgorithm {
    <V, F, E extends CapacityEdge<V, F>> MaximumFlowAlgorithmResult<F, E> calc(Graph<V, E> capacityGraph, V start, V end, AddableNumberSystem<F> ns);
}