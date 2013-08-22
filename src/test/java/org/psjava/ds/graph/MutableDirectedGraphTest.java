package org.psjava.ds.graph;

import org.junit.Test;

public class MutableDirectedGraphTest {

	@Test(expected = RuntimeException.class)
	public void testInvalidEdge() {
		MutableDirectedGraph<DirectedEdge> g = new MutableDirectedGraph<DirectedEdge>();
		g.insertVertex("A");
		g.addEdge(DirectedEdgeFactory.create("A", "B"));
	}

}
