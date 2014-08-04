package org.psjava.goods;

import org.psjava.algo.graph.shortestpath.DijkstraAlgorithm;
import org.psjava.ds.heap.BinaryHeapFactory;

public class GoodDijkstraAlgorithm {

	public static DijkstraAlgorithm getInstance() {
		return DijkstraAlgorithm.getInstance(BinaryHeapFactory.getInstance());
	}

	private GoodDijkstraAlgorithm() {
	}

}
