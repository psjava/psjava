package org.psjava.goods;

import org.psjava.algo.graph.shortestpath.Dijkstra;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathAlgorithm;
import org.psjava.ds.heap.BinaryHeapFactory;

public class GoodSingleSourceShortestPathAlgorithm {

	public static SingleSourceShortestPathAlgorithm getInstance() {
		return new Dijkstra(new BinaryHeapFactory());
	}

	private GoodSingleSourceShortestPathAlgorithm() {
	}
}
