package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.graph.FlowNetworkEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.util.DataFilter;

public class ResidualNetworkFilter {

	public static <F, E extends FlowNetworkEdge<?, F, ?>> DataFilter<E> create(final AddableNumberSystem<F> ns) {
		return new DataFilter<E>() {
			@Override
			public boolean isAccepted(E v) {
				return ns.isPositive(Residual.calc(v, ns));
			}
		};
	}

}
