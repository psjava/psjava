package org.psjava.ds.graph;

import org.psjava.util.FilteredIterable;

import java.util.Collection;
import java.util.function.Predicate;

public class EdgeFilteredSubGraph {

    public static <V, E> Graph<V, E> wrap(final Graph<V, E> original, final Predicate<E> filter) {
        return new Graph<V, E>() {
            @Override
            public Collection<V> getVertices() {
                return original.getVertices();
            }

            @Override
            public Iterable<E> getEdges(V v) {
                return FilteredIterable.create(original.getEdges(v), filter);
            }

            @Override
            public String toString() {
                return GraphToString.toString(this);
            }
        };
    }

    private EdgeFilteredSubGraph() {
    }
}
