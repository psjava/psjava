package org.psjava.ds.graph;

public class SimpleCapacityEdge {

    public static <V, W> CapacityEdge<V, W> create(final V from, final V to, final W capacity) {
        return new CapacityEdge<V, W>() {
            @Override
            public V from() {
                return from;
            }

            @Override
            public V to() {
                return to;
            }

            @Override
            public W capacity() {
                return capacity;
            }

            @Override
            public String toString() {
                return DirectedEdgeToString.toString(this) + "(" + capacity() + ")";
            }
        };
    }

    private SimpleCapacityEdge() {
    }

}