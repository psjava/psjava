package org.psjava.algo.graph;

import org.psjava.algo.graph.matching.MaximumBipartiteMatchingAlgorithm;
import org.psjava.ds.graph.BipartiteGraph;

public class KonigTheorem {

    public static MinimumVertexCoverAlgorithmInBipartiteGraph getInstance(final MaximumBipartiteMatchingAlgorithm subAlgorithm) {
        return new MinimumVertexCoverAlgorithmInBipartiteGraph() {
            @Override
            public <V, E> int calcMinimumVertexCover(BipartiteGraph<V> bg) {
                return subAlgorithm.calc(bg).getMaxMatchCount();
            }
        };
    }

    private KonigTheorem() {
    }

}
