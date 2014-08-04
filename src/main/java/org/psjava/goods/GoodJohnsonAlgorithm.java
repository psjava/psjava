package org.psjava.goods;

import org.psjava.algo.graph.shortestpath.AllPairShortestPath;
import org.psjava.algo.graph.shortestpath.BellmanFordAlgorithm;
import org.psjava.algo.graph.shortestpath.JohnsonAlgorithm;

public class GoodJohnsonAlgorithm {
	public static AllPairShortestPath getInstance() {
		return JohnsonAlgorithm.getInstance (BellmanFordAlgorithm.getInstance(), GoodDijkstraAlgorithm.getInstance());
	}
	private GoodJohnsonAlgorithm() {
	}
}
