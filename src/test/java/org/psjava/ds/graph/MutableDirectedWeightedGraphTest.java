package org.psjava.ds.graph;

import org.junit.Test;

public class MutableDirectedWeightedGraphTest {

	@Test(expected = RuntimeException.class)
	public void testInvalidEdge() {
		MutableDirectedWeightedGraph<String, Integer> g = new MutableDirectedWeightedGraph<String, Integer>();
		g.insertVertex("A");
		g.addEdge("A", "B", 1);
	}

}
