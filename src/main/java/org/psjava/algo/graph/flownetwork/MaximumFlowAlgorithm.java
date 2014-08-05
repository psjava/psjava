package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.graph.CapacityEdge;
import org.psjava.ds.graph.OldGraph;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public interface MaximumFlowAlgorithm {
	<V, F, E extends CapacityEdge<V, F>> MaximumFlowAlgorithmResult<F, E> calc(OldGraph<V, E> capacityOldGraph, V start, V end, AddableNumberSystem<F> ns);
}