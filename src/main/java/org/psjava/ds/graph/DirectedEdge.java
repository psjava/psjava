package org.psjava.ds.graph;

public interface DirectedEdge<V> { // TODO introduce Edge interface, and assert existence in MutableGraph
	V from();

	V to();
}
