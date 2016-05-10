package org.psjava.ds.graph;

import org.psjava.util.Converter;

public class DirectedWeightedGraphFromUndirected {

	public static <V, W, E1 extends UndirectedWeightedEdge<V, W>> Graph<V, DirectedWeightedEdge<V, W>> wrap(final Graph<V, E1> original) {
		return EdgeDoubledGraph.wrap(original, new Converter<E1, DirectedWeightedEdge<V, W>>() {
			@Override
			public DirectedWeightedEdge<V, W> convert(E1 original) {
				return SimpleDirectedWeightedEdge.create(original.v1(), original.v2(), original.weight());
			}
		}, new Converter<E1, DirectedWeightedEdge<V, W>>() {
			@Override
			public DirectedWeightedEdge<V, W> convert(E1 original) {
				return SimpleDirectedWeightedEdge.create(original.v2(), original.v1(), original.weight());
			}
		});
	}

	private DirectedWeightedGraphFromUndirected() {
	}

}
