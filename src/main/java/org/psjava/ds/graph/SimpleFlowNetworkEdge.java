package org.psjava.ds.graph;

import org.psjava.util.AssertStatus;

public class SimpleFlowNetworkEdge<V, F> {

	public static <V, F, E> FlowNetworkEdge<V, F, E> create(final V from, final V to, final FlowStatus<F> flowStatus, final E originalOrNull) {
		return new FlowNetworkEdge<V, F, E>() {
			FlowNetworkEdge<V, F, E> symmetry;

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
			public FlowNetworkEdge<V, F, E> getSymmetryEdge() {
				AssertStatus.assertTrue(symmetry != null, "Reversed edge is not set");
				return symmetry;
			}

			@Override
			public void setSymmetryEdge(FlowNetworkEdge<V, F, E> reversed) {
				this.symmetry = reversed;
			}

			@Override
			public boolean hasOriginalCapacityEdge() {
				return originalOrNull != null;
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