package org.psjava;

import org.psjava.util.Filter;
import org.psjava.util.FilteredIterable;

public class EdgeFilteredSubAdjacencyList {
    public static <V, E> AdjacencyList<V, E> wrap(AdjacencyList<V, E> original, Filter<E> edgeFilter) {
        return source -> FilteredIterable.create(original.get(source), edgeFilter);
    }
}
