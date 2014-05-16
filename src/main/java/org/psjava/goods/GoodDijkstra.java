package org.psjava.goods;

import org.psjava.algo.graph.shortestpath.Dijkstra;
import org.psjava.ds.heap.BinaryHeapFactory;

public class GoodDijkstra {

	public static Dijkstra getInstance() {
		return new Dijkstra(new BinaryHeapFactory());
	}

	private GoodDijkstra() {
	}

}
