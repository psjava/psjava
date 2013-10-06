package org.psjava.ds.graph;

public interface DirectedWeightedEdge<V, W> extends DirectedEdge<V> {
	W weight();
}
