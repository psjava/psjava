package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.util.DataFilter;
import org.psjava.util.FilteredIterable;

public class EdgeFilteredSubNewGraph {

	public static <V, E extends DirectedEdge<V>> Graph<V, E> wrap(final Graph<V, E> g, final DataFilter<E> filter) {
		return new Graph<V, E>() {
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

	private EdgeFilteredSubNewGraph() {
	}

}
