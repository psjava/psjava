package org.psjava.goods;

import org.psjava.algo.graph.shortestpath.Dijkstra;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPath;
import org.psjava.ds.heap.BinaryHeapFactory;

public class GoodSingleSourceShortestPath {

	public static SingleSourceShortestPath getInstance() {
		return new Dijkstra(new BinaryHeapFactory());
	}

	private GoodSingleSourceShortestPath() {
	}
}
