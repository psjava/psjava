package org.psjava.goods;

import org.psjava.algo.graph.shortestpath.AllPairShortestPath;
import org.psjava.algo.graph.shortestpath.BellmanFordAlgorithm;
import org.psjava.algo.graph.shortestpath.JohnsonAlgorithm;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathAlgorithmUsingV2;

public class GoodJohnsonAlgorithm {
	public static AllPairShortestPath getInstance() {
		return JohnsonAlgorithm.getInstance (SingleSourceShortestPathAlgorithmUsingV2.wrap(BellmanFordAlgorithm.getInstance()), GoodDijkstraAlgorithm.getInstance());
	}
	private GoodJohnsonAlgorithm() {
	}
}
