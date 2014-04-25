package org.psjava.ds.graph;

public class TestGraphFactory {

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

	public static Graph<String, UndirectedEdge<String>> createUndirected(String[][] edata) {
		MutableUndirectedGraph<String> g = MutableUndirectedGraph.create();
		for (String[] e : edata) {
			g.insertVertex(e[0]);
			g.insertVertex(e[1]);
			g.addEdge(e[0], e[1]);
		}
		return g;
	}

	public static Graph<String, CapacityEdge<String, Integer>> createCapacityGraph(Object[][] edata) {
		MutableCapacityGraph<String, Integer> g = MutableCapacityGraph.create();
		for (Object[] e : edata) {
			g.insertVertex((String) e[0]);
			g.insertVertex((String) e[1]);
			g.addEdge((String) e[0], (String) e[1], (Integer) e[2]);
		}
		return g;
	}

	public static MutableDirectedWeightedGraph<String, Integer> createDirectedWeighted(Object[][] data) {
		MutableDirectedWeightedGraph<String, Integer> g = MutableDirectedWeightedGraph.create();
		for (Object[] e1 : data) {
			g.insertVertex((String) e1[0]);
			g.insertVertex((String) e1[1]);
			g.addEdge((String) e1[0], (String) e1[1], (int) (Integer) e1[2]);
		}
		return g;
	}

	public static MutableUndirectedWeightedGraph<String, Integer> createUndirectedWeighted(Object[][] data) {
		MutableUndirectedWeightedGraph<String, Integer> g = MutableUndirectedWeightedGraph.create();
		for (Object[] e1 : data) {
			g.insertVertex((String) e1[0]);
			g.insertVertex((String) e1[1]);
			g.addEdge((String) e1[0], (String) e1[1], (Integer) e1[2]);
		}
		return g;
	}

}
