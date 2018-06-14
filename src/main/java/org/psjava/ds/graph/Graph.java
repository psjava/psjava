package org.psjava.ds.graph;

import org.psjava.ds.PSCollection;

@Deprecated
public interface Graph<V, E> {
    PSCollection<V> getVertices();

    Iterable<E> getEdges(V from);
}