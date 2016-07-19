package org.psjava.ds.graph;

public interface CapacityEdge<V, F> extends DirectedEdge<V> {
    F capacity();
}
