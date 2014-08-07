package org.psjava.algo.graph.matching;

public class HopcroftKarpAlgorithmTest extends MaximumBipartiteMatchingAlgorithmTestBase {

	@Override
	protected MaximumBipartiteMatchingAlgorithm getInstance() {
		return HopcroftKarpAlgorithm.getInstance();
	}

}
