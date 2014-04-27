package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.graph.AdjacencyList;
import org.psjava.ds.graph.EdgeFilteredSubAdjacencyList;
import org.psjava.ds.graph.FlowNetworkEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class ResidualNetworkAdjacencyList {
	public static <V, F, E extends FlowNetworkEdge<V, F, ?>> AdjacencyList<V, E> wrap(AdjacencyList<V, E> adj, final AddableNumberSystem<F> ns) {
		return EdgeFilteredSubAdjacencyList.wrap(adj, ResidualNetworkFilter.<F, E> create(ns));
	}

	private ResidualNetworkAdjacencyList() {
	}
}
