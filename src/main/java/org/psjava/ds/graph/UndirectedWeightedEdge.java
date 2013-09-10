package org.psjava.ds.graph;

public interface UndirectedWeightedEdge<W> {
	Object v1();

	Object v2();

	W weight();
}
