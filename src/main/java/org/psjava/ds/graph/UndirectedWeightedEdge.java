package org.psjava.ds.graph;

public interface UndirectedWeightedEdge<V, W> {
	V v1();

	V v2();

	W weight();
}
