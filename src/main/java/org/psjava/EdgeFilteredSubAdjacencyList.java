package org.psjava;

import org.psjava.util.FilteredIterable;

import java.util.function.Predicate;

public class EdgeFilteredSubAdjacencyList {
    public static <V, E> AdjacencyList<V, E> wrap(AdjacencyList<V, E> original, Predicate<E> edgeFilter) {
        return source -> FilteredIterable.create(original.get(source), edgeFilter);
    }
}
