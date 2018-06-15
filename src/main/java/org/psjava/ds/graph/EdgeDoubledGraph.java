package org.psjava.ds.graph;

import org.psjava.util.ConvertedIterable;
import org.psjava.util.Converter;
import org.psjava.util.MergedIterable;
import org.psjava.util.VarargsIterable;

import java.util.Collection;

// todo inline
public class EdgeDoubledGraph {

    public static <V, W, E1, E2> Graph<V, E2> wrap(final Graph<V, E1> original, final Converter<E1, E2> direction1Converter, final Converter<E1, E2> direction2Converter) {
        return new Graph<V, E2>() {
            @Override
            public Collection<V> getVertices() {
                return original.getVertices();
            }

            @SuppressWarnings("unchecked")
            @Override
            public Iterable<E2> getEdges(V v) {
                return MergedIterable.wrap(VarargsIterable.create(ConvertedIterable.create(original.getEdges(v), direction1Converter),
                        ConvertedIterable.create(original.getEdges(v), direction2Converter)));
            }

            @Override
            public String toString() {
                return GraphToString.toString(this);
            }
        };
    }

    private EdgeDoubledGraph() {
    }

}
