package org.psjava.ds.graph;

import org.psjava.util.AssertStatus;

public class SimpleFlowNetworkEdge<V, F> {

	public static <V, F, E> FlowNetworkEdge<V, F, E> create(final V from, final V to, final FlowStatus<F> flowStatus, final E originalOrNull) {
		return new FlowNetworkEdge<V, F, E>() {
			FlowNetworkEdge<V, F, E> opposite;

			@Override
			public V from() {
				return from;
			}

			@Override
			public V to() {
				return to;
			}

			@Override
			public FlowStatus<F> getFlowStatus() {
				return flowStatus;
			}

			@Override
			public FlowNetworkEdge<V, F, E> getOpposite() {
				AssertStatus.assertTrue(opposite != null, "Reversed edge is not set");
				return opposite;
			}

			@Override
			public void setOpposite(FlowNetworkEdge<V, F, E> edge) {
				this.opposite = edge;
			}

			@Override
			public boolean isSkewSymmetryEdge() {
				return originalOrNull == null;
			}

			@Override
			public E getOriginalCapacityEdge() {
				return originalOrNull;
			}

			@Override
			public String toString() {
				return DirectedEdgeToString.toString(this) + "(" + getFlowStatus() + ")";
			}
		};
	}

}