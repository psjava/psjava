package org.psjava;

class BipartiteGraphEdge<V> {
    final V left;
    final V right;

    BipartiteGraphEdge(V left, V right) {
        this.left = left;
        this.right = right;
    }
}
