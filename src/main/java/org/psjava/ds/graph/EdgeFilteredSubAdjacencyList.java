package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.util.DataFilter;
import org.psjava.util.FilteredIterable;

public class EdgeFilteredSubAdjacencyList {

	public static <V, E extends DirectedEdge<V>> AdjacencyList<V, E> wrap(final AdjacencyList<V, E> g, final DataFilter<E> filter) {
		return new AdjacencyList<V, E>() {
			@Override
			public Collection<V> getVertices() {
				return g.getVertices();
			}

			@Override
			public Iterable<E> getEdges(V from) {
				return FilteredIterable.create(g.getEdges(from), filter);
			}
		};
	}

	private EdgeFilteredSubAdjacencyList() {
	}

}
