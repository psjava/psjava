package org.psjava.algo.graph;

import org.psjava.algo.graph.matching.MaximumBipartiteMatchingAlgorithm;

public class KonigTheorem {

    public static MinimumVertexCoverAlgorithmInBipartiteGraph getInstance(final MaximumBipartiteMatchingAlgorithm subAlgorithm) {
        return subAlgorithm::calc;
    }

}
