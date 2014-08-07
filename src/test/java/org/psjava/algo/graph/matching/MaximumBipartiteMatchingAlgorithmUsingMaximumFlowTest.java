package org.psjava.algo.graph.matching;

import org.psjava.algo.graph.flownetwork.EdmondsKarpAlgorithm;

public class MaximumBipartiteMatchingAlgorithmUsingMaximumFlowTest extends MaximumBipartiteMatchingAlgorithmTestBase {

	@Override
	protected MaximumBipartiteMatchingAlgorithm getInstance() {
		return MaximumBipartiteMatchingAlgorithmUsingMaximumFlow.getInstance(EdmondsKarpAlgorithm.getInstance());
	}
}