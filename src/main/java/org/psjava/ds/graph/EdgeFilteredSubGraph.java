package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.util.DataFilter;
import org.psjava.util.FilteredIterable;

public class EdgeFilteredSubGraph {

	public static <V, E> OldGraph<V, E> wrap(final OldGraph<V, E> original, final DataFilter<E> filter) {
		return new OldGraph<V, E>() {
			@Override
			public Collection<V> getVertices() {
				return original.getVertices();
			}

			@Override
			public Iterable<E> getEdges() {
				return FilteredIterable.create(original.getEdges(), filter);
			}

			@Override
			public String toString() {
				return GraphToString.toString(this);
			}
		};
	}

	private EdgeFilteredSubGraph() {
	}
}
