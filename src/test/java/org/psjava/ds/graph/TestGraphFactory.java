package org.psjava.ds.graph;

public class TestGraphFactory {

	@Deprecated // Use String key graph.
	public static MutableDirectedWeightedOldGraph<Integer, Integer> createDirectedWeighted(int[][] edata) {
		MutableDirectedWeightedOldGraph<Integer, Integer> g = new MutableDirectedWeightedOldGraph<Integer, Integer>();
		for (int[] e : edata) {
			g.insertVertex(e[0]);
			g.insertVertex(e[1]);
			g.addEdge(e[0], e[1], e[2]);
		}
		return g;
	}

	public static MutableDirectedWeightedGraph<Integer, Integer> createDirectedWeightedNew(int[][] edata) {
		MutableDirectedWeightedGraph<Integer, Integer> g = new MutableDirectedWeightedGraph<Integer, Integer>();
		for (int[] e : edata) {
			g.insertVertex(e[0]);
			g.insertVertex(e[1]);
			g.addEdge(e[0], e[1], e[2]);
		}
		return g;
	}

	@Deprecated
	public static OldGraph<String, DirectedEdge<String>> createDirected(String[][] edata) {
		MutableDirectedOldGraph<String> g = MutableDirectedOldGraph.create();
		for (String[] e : edata) {
			g.insertVertex(e[0]);
			g.insertVertex(e[1]);
			g.addEdge(e[0], e[1]);
		}
		return g;
	}

	@Deprecated
	public static OldGraph<String, UndirectedEdge<String>> createUndirected(String[][] edata) {
		MutableUndirectedOldGraph<String> g = MutableUndirectedOldGraph.create();
		for (String[] e : edata) {
			g.insertVertex(e[0]);
			g.insertVertex(e[1]);
			g.addEdge(e[0], e[1]);
		}
		return g;
	}

	@Deprecated
	public static OldGraph<String, CapacityEdge<String, Integer>> createCapacityGraph(Object[][] edata) {
		MutableCapacityOldGraph<String, Integer> g = MutableCapacityOldGraph.create();
		for (Object[] e : edata) {
			g.insertVertex((String) e[0]);
			g.insertVertex((String) e[1]);
			g.addEdge((String) e[0], (String) e[1], (Integer) e[2]);
		}
		return g;
	}

	@Deprecated
	public static MutableDirectedWeightedOldGraph<String, Integer> createDirectedWeighted(Object[][] data) {
		MutableDirectedWeightedOldGraph<String, Integer> g = MutableDirectedWeightedOldGraph.create();
		for (Object[] e1 : data) {
			g.insertVertex((String) e1[0]);
			g.insertVertex((String) e1[1]);
			g.addEdge((String) e1[0], (String) e1[1], (int) (Integer) e1[2]);
		}
		return g;
	}

	public static MutableDirectedWeightedGraph<String, Integer> createDirectedWeightedNew(Object[][] data) {
		MutableDirectedWeightedGraph<String, Integer> g = MutableDirectedWeightedGraph.create();
		for (Object[] e1 : data) {
			g.insertVertex((String) e1[0]);
			g.insertVertex((String) e1[1]);
			g.addEdge((String) e1[0], (String) e1[1], (int) (Integer) e1[2]);
		}
		return g;
	}

	@Deprecated
	public static MutableUndirectedWeightedOldGraph<String, Integer> createUndirectedWeighted(Object[][] data) {
		MutableUndirectedWeightedOldGraph<String, Integer> g = MutableUndirectedWeightedOldGraph.create();
		for (Object[] e1 : data) {
			g.insertVertex((String) e1[0]);
			g.insertVertex((String) e1[1]);
			g.addEdge((String) e1[0], (String) e1[1], (Integer) e1[2]);
		}
		return g;
	}

}
