package org.psjava.ds.graph;

import org.psjava.util.ConvertedIterable;
import org.psjava.util.Converter;
import org.psjava.util.MergedIterable;

public class AllEdgeInGraph {
    public static <V, E> Iterable<E> wrap(final Graph<V, E> g) {
        return MergedIterable.wrap(ConvertedIterable.create(g.getVertices(), new Converter<V, Iterable<? extends E>>() {
            @Override
            public Iterable<? extends E> convert(V v) {
                return g.getEdges(v);
            }
        }));
    }

    private AllEdgeInGraph() {
    }
}
