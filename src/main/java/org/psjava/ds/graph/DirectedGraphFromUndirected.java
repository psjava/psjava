package org.psjava.ds.graph;

import org.psjava.util.Converter;

public class DirectedGraphFromUndirected {

    public static <V, E extends UndirectedEdge<V>> Graph<V, DirectedEdge<V>> wrap(final Graph<V, E> original) {
        return EdgeDoubledGraph.wrap(original, new Converter<E, DirectedEdge<V>>() {
            @Override
            public DirectedEdge<V> convert(E original) {
                return SimpleDirectedEdge.create(original.v1(), original.v2());
            }
        }, new Converter<E, DirectedEdge<V>>() {
            @Override
            public DirectedEdge<V> convert(E original) {
                return SimpleDirectedEdge.create(original.v2(), original.v1());
            }
        });
    }

    private DirectedGraphFromUndirected() {
    }

}
