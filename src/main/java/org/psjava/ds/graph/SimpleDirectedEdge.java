package org.psjava.ds.graph;

public class SimpleDirectedEdge {

    public static <V> DirectedEdge<V> create(final V from, final V to) {
        return new DirectedEdge<V>() {
            @Override
            public V to() {
                return to;
            }

            @Override
            public V from() {
                return from;
            }

            @Override
            public String toString() {
                return DirectedEdgeToString.toString(this);
            }
        };
    }

    private SimpleDirectedEdge() {
    }

}
