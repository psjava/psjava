package org.psjava.ds.graph;

import org.psjava.util.DataConverter;

public class DirectedWeightedGraphFromUndirected {

	public static <V, W, E1 extends UndirectedWeightedEdge<V, W>> OldGraph<V, DirectedWeightedEdge<V, W>> wrap(final OldGraph<V, E1> original) {
		return EdgeDoubledGraph.wrap(original, new DataConverter<E1, DirectedWeightedEdge<V, W>>() {
			@Override
			public DirectedWeightedEdge<V, W> convert(E1 original) {
				return SimpleDirectedWeightedEdge.create(original.v1(), original.v2(), original.weight());
			}
		}, new DataConverter<E1, DirectedWeightedEdge<V, W>>() {
			@Override
			public DirectedWeightedEdge<V, W> convert(E1 original) {
				return SimpleDirectedWeightedEdge.create(original.v2(), original.v1(), original.weight());
			}
		});
	}

	private DirectedWeightedGraphFromUndirected() {
	}

}
