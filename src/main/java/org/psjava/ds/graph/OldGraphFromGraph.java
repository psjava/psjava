package org.psjava.ds.graph;

import org.psjava.ds.Collection;

@Deprecated
public class OldGraphFromGraph {
	public static <V,E> OldGraph<V, E> wrap(final Graph<V, E> augmented) {
		return new OldGraph<V,E>() {
			@Override
			public Collection<V> getVertices() {
				return augmented.getVertices();
			}

			@Override
			public Iterable<E> getEdges() {
				return AllEdgeInGraph.create(augmented);
			}
		};
	}
}
