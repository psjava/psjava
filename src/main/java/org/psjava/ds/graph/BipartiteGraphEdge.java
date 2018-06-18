package org.psjava.ds.graph;

public class BipartiteGraphEdge<V> {
    public final V left;
    public final V right;

    public BipartiteGraphEdge(V left, V right) {
        this.left = left;
        this.right = right;
    }
}
