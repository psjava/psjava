package org.psjava.ds.graph;

import org.junit.Test;

public class MutableDirectedWeightedOldGraphTest {

	@Test(expected = RuntimeException.class)
	public void testInvalidEdge() {
		MutableDirectedWeightedOldGraph<String, Integer> g = new MutableDirectedWeightedOldGraph<String, Integer>();
		g.insertVertex("A");
		g.addEdge("A", "B", 1);
	}

}
