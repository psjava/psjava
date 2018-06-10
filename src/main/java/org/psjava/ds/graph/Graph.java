package org.psjava.ds.graph;

import org.psjava.ds.PSCollection;

public interface Graph<V, E> {
    PSCollection<V> getVertices();

    Iterable<E> getEdges(V from);
}