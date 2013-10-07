package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.javautil.DataFilter;
import org.psjava.javautil.FilteredIterable;

public class EdgeFilteredGraph {

	// TODO introduce SubGraph and replace this

	public static <V, E> Graph<V, E> wrap(final Graph<V, E> original, final DataFilter<E> filter) {
		return new Graph<V, E>() {
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

}
