package org.psjava.algo.graph.flownetwork;

import org.psjava.algo.graph.pathfinder.BFSPathFinder;

public class EdmondsKarpAlgorithm {

	public static MaximumFlowAlgorithm getInstance() {
		return FordFulkersonAlgorithm.getInstance(new BFSPathFinder());
	}

	private EdmondsKarpAlgorithm() {
	}

}
