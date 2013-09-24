package org.psjava.ds.graph;

public interface DirectedEdge<V> {
	V from(); // TODO rename to tail

	V to(); // TODO rename to head
}
