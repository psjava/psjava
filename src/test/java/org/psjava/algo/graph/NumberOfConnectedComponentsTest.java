package org.psjava.algo.graph;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.graph.OldGraph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.ds.graph.UndirectedEdge;

public class NumberOfConnectedComponentsTest {

	@Test
	public void test() {
		String[][] data = new String[][] { { "A", "B" }, { "B", "C" }, { "D", "E" } };
		OldGraph<String, UndirectedEdge<String>> g = TestGraphFactory.createUndirected(data);
		Assert.assertEquals(2, NumberOfConnectedComponents.calc(g));
	}

}
