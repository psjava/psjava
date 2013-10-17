package org.psjava.ds.graph;


public interface FlowNetworkEdge<V, F, E> extends DirectedEdge<V> {
	FlowStatus<F> getFlowStatus();

	FlowNetworkEdge<V, F, E> getSymmetryEdge();

	void setSymmetryEdge(FlowNetworkEdge<V, F, E> symmetry);

	boolean hasOriginalCapacityEdge();

	E getOriginalCapacityEdge();
}
