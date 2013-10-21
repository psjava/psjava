package org.psjava.ds.graph;

public interface FlowNetworkEdge<V, F, E> extends DirectedEdge<V> {
	FlowStatus<F> getFlowStatus();

	void setOpposite(FlowNetworkEdge<V, F, E> edge);

	FlowNetworkEdge<V, F, E> getOpposite();

	boolean isSkewSymmetryEdge();

	E getOriginalCapacityEdge();
}
