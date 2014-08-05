package org.psjava.algo.graph.flownetwork;

import org.psjava.ds.graph.EdgeFilteredSubNewGraph;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.FlowNetworkEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class ResidualNetworkNewGraph {
	public static <V, F, E extends FlowNetworkEdge<V, F, ?>> Graph<V, E> wrap(Graph<V, E> graph, final AddableNumberSystem<F> ns) {
		return EdgeFilteredSubNewGraph.wrap(graph, ResidualNetworkFilter.<F, E>create(ns));
	}

	private ResidualNetworkNewGraph() {
	}
}
