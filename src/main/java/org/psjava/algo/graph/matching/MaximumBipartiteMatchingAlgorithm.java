package org.psjava.algo.graph.matching;

import org.psjava.ds.graph.BipartiteGraph;

public interface MaximumBipartiteMatchingAlgorithm {
    <V> int calc(BipartiteGraph<V> graph);
}
