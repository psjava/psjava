package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.graph.FlowNetworkEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.util.Filter;

public class ResidualNetworkFilter {

	public static <F, E extends FlowNetworkEdge<?, F, ?>> Filter<E> create(final AddableNumberSystem<F> ns) {
		return new Filter<E>() {
			@Override
			public boolean isAccepted(E v) {
				return ns.isPositive(Residual.calc(v, ns));
			}
		};
	}

	private ResidualNetworkFilter() {
	}

}
