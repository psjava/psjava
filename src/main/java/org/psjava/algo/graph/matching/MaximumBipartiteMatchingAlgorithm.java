package org.psjava.algo.graph.matching;

import org.psjava.BipartiteGraph;

@Deprecated
public interface MaximumBipartiteMatchingAlgorithm {
    <V> int calc(BipartiteGraph<V> graph);
}
