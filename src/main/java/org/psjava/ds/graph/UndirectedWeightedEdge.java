package org.psjava.ds.graph;

public interface UndirectedWeightedEdge<V, W> extends UndirectedEdge<V> {
    W weight();
}
