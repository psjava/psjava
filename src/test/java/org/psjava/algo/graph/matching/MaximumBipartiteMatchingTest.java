package org.psjava.algo.graph.matching;

import org.psjava.MaximumBipartiteMatching;

public class MaximumBipartiteMatchingTest extends MaximumBipartiteMatchingAlgorithmTestBase {

    @Override
    protected MaximumBipartiteMatchingAlgorithm getInstance() {
        return MaximumBipartiteMatching::calculate;
    }

}
