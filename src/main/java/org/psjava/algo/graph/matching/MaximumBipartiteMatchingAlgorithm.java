package org.psjava.algo.graph.matching;

import org.psjava.ds.graph.BipartiteGraph;

public interface MaximumBipartiteMatchingAlgorithm {
    <V> MaximumBipartiteMatchingResult<V> calc(BipartiteGraph<V> graph);
}
