package org.psjava.ds.graph;

import java.util.Collection;

@Deprecated
public interface Graph<V, E> {
    Collection<V> getVertices();

    Iterable<E> getEdges(V from);
}