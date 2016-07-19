package org.psjava.ds.graph;

public class SimpleUndirectedWeightedEdge {

    public static <V, W> UndirectedWeightedEdge<V, W> create(final V v1, final V v2, final W weight) {
        return new UndirectedWeightedEdge<V, W>() {

            @Override
            public V v1() {
                return v1;
            }

            @Override
            public V v2() {
                return v2;
            }

            @Override
            public W weight() {
                return weight;
            }

            @Override
            public String toString() {
                return v1 + "-" + v2 + "(" + weight + ")";
            }
        };
    }

    private SimpleUndirectedWeightedEdge() {
    }

}