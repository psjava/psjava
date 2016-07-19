package org.psjava.ds.graph;

public class SimpleUndirectedEdge {

    public static <V> UndirectedEdge<V> create(final V v1, final V v2) {
        return new UndirectedEdge<V>() {

            @Override
            public V v1() {
                return v1;
            }

            @Override
            public V v2() {
                return v2;
            }

            @Override
            public String toString() {
                return v1 + "-" + v2;
            }
        };
    }

    private SimpleUndirectedEdge() {
    }

}