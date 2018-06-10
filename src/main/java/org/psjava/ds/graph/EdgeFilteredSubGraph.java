package org.psjava.ds.graph;

import org.psjava.ds.PSCollection;
import org.psjava.util.Filter;
import org.psjava.util.FilteredIterable;

public class EdgeFilteredSubGraph {

    public static <V, E> Graph<V, E> wrap(final Graph<V, E> original, final Filter<E> filter) {
        return new Graph<V, E>() {
            @Override
            public PSCollection<V> getVertices() {
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
