package org.psjava.algo.graph.flownetwork;

import org.psjava.algo.graph.pathfinder.BFSPathFinder;

/**
 * Implementation of Edmonds–Karp algorithm
 * 
 * http://en.wikipedia.org/wiki/Edmonds%E2%80%93Karp_algorithm
 * 
 */

public class EdmondsKarpAlgorithm {

	public static MaximumFlowAlgorithm getInstance() {
		// Edmonds–Karp algorithm is just one of specializations of Ford–Fulkerson algorithm.
		return FordFulkersonAlgorithm.getInstance(BFSPathFinder.getInstance());
	}

	private EdmondsKarpAlgorithm() {
	}

}
