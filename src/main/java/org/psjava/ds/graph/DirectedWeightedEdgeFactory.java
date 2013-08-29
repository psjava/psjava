package org.psjava.ds.graph;

import org.psjava.ds.graph.DirectedWeightedEdge;

public class DirectedWeightedEdgeFactory {

	public static <W> DirectedWeightedEdge<W> create(final Object from, final Object to, final W weight) {
		return new DirectedWeightedEdge<W>() {

			@Override
			public Object from() {
				return from;
			}

			@Override
			public Object to() {
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