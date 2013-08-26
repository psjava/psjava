package org.psjava.ds.graph;

import org.junit.Test;

public class MutableDirectedWeightedGraphTest {

	@Test(expected = RuntimeException.class)
	public void testInvalidEdge() {
		MutableDirectedWeightedGraph<Integer> g = new MutableDirectedWeightedGraph<Integer>();
		g.insertVertex("A");
		g.addEdge("A", "B", 1);
	}

}
