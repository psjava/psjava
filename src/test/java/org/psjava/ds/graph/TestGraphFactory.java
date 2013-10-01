package org.psjava.ds.graph;

public class TestGraphFactory {

	// TODO rename createDirectedWeighted
	public static MutableDirectedWeightedGraph<Integer, Integer> create(int[][] edata) { 
		MutableDirectedWeightedGraph<Integer, Integer> g = new MutableDirectedWeightedGraph<Integer, Integer>();
		for (int[] e : edata) {
			g.insertVertex(e[0]);
			g.insertVertex(e[1]);
			g.addEdge(e[0], e[1], e[2]);
		}
		return g;
	}

	public static Graph<String, DirectedEdge<String>> createDirected(String[][] edata) {
		MutableDirectedGraph<String> g = MutableDirectedGraph.create();
		for (String[] e : edata) {
			g.insertVertex(e[0]);
			g.insertVertex(e[1]);
			g.addEdge(e[0], e[1]);
		}
		return g;
	}

}
