package org.psjava.goods;

import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathAlgorithm;

public class GoodSingleSourceShortestPathAlgorithm {

	public static SingleSourceShortestPathAlgorithm getInstance() {
		return GoodDijkstraAlgorithm.getInstance();
	}

	private GoodSingleSourceShortestPathAlgorithm() {
	}
}
