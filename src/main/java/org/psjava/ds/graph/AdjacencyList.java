package org.psjava.ds.graph;

import org.psjava.ds.Collection;

public interface AdjacencyList<V, E> {
	Collection<V> getVertices();

	Iterable<E> getEdges(V from);
}