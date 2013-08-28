package org.psjava.ds.graph;

public class TestGraphFactory {

	public static DirectedWeightedGraph<Integer> create(int[][] edata) {
		MutableDirectedWeightedGraph<Integer> g = new MutableDirectedWeightedGraph<Integer>();
		for (int[] e : edata) {
			g.insertVertex(e[0]);
			g.insertVertex(e[1]);
			g.addEdge(e[0], e[1], e[2]);
		}
		return g;
	}

}
