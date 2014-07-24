package org.psjava.goods;

import org.psjava.algo.graph.shortestpath.DijkstraAlgorithm;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathAlgorithm;
import org.psjava.ds.heap.BinaryHeapFactory;

public class GoodSingleSourceShortestPathAlgorithm {

	public static SingleSourceShortestPathAlgorithm getInstance() {
		return new DijkstraAlgorithm(new BinaryHeapFactory());
	}

	private GoodSingleSourceShortestPathAlgorithm() {
	}
}
