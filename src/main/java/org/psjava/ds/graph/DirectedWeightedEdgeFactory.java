package org.psjava.ds.graph;

import org.psjava.ds.graph.DirectedWeightedEdge;

public class DirectedWeightedEdgeFactory {

	public static <V, W> DirectedWeightedEdge<V, W> create(final V from, final V to, final W weight) {
		return new DirectedWeightedEdge<V, W>() {

			@Override
			public V from() {
				return from;
			}

			@Override
			public V to() {
				return to;
			}

			@Override
			public W weight() {
				return weight;
			}

			@Override
			public String toString() {
				return from + "->" + to + "(" + weight + ")";
			}
		};
	}

}