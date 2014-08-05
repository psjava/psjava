package org.psjava.ds.graph;

import org.psjava.ds.Collection;

@Deprecated
public interface OldGraph<V, E> {
	Collection<V> getVertices();

	Iterable<E> getEdges();
}
