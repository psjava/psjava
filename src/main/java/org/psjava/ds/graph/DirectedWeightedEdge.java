package org.psjava.ds.graph;

@Deprecated
public interface DirectedWeightedEdge<V, W> extends DirectedEdge<V> {
	W weight();
}
