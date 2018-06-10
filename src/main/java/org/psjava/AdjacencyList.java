package org.psjava;

public interface AdjacencyList<V, E> {
    Iterable<E> get(V source);
}
