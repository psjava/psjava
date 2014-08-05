package org.psjava.ds.graph;

import org.psjava.util.DataConverter;

public class DirectedGraphFromUndirected {

	public static <V, E extends UndirectedEdge<V>> OldGraph<V, DirectedEdge<V>> wrap(final OldGraph<V, E> original) {
		return EdgeDoubledGraph.wrap(original, new DataConverter<E, DirectedEdge<V>>() {
			@Override
			public DirectedEdge<V> convert(E original) {
				return SimpleDirectedEdge.create(original.v1(), original.v2());
			}
		}, new DataConverter<E, DirectedEdge<V>>() {
			@Override
			public DirectedEdge<V> convert(E original) {
				return SimpleDirectedEdge.create(original.v2(), original.v1());
			}
		});
	}

	private DirectedGraphFromUndirected() {
	}

}
