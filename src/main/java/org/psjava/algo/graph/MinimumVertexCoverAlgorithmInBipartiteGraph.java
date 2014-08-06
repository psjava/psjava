package org.psjava.algo.graph;

import org.psjava.ds.graph.BipartiteGraph;

public interface MinimumVertexCoverAlgorithmInBipartiteGraph {
	<V,E> int calcMinimumVertexCover(BipartiteGraph<V> bg);
}
