package org.psjava.algo.graph.matching;

import org.psjava.ds.graph.BipartiteGraph;

public interface MaximumBipartiteMatching {
	<V> MaximumBipartiteMatchingResult<V> calc(BipartiteGraph<V> graph);
}
