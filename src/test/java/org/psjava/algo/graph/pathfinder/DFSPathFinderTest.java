package org.psjava.algo.graph.pathfinder;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.Collection;
import org.psjava.ds.graph.NewGraphFromGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.OldGraph;
import org.psjava.ds.graph.TestGraphFactory;

public class DFSPathFinderTest {

	@Test
	public void test() {
		OldGraph<String, DirectedEdge<String>> g = TestGraphFactory.createDirected(new String[][] { { "A", "B" }, { "B", "C" }, { "C", "D" } });
		Collection<DirectedEdge<String>> r = DFSPathFinder.getInstance().find(NewGraphFromGraph.createFromDirected(g), "A", "C", null);
		Assert.assertEquals("(A->B,B->C)", r.toString());
	}

	@Test
	public void testNoPath() {
		OldGraph<String, DirectedEdge<String>> g = TestGraphFactory.createDirected(new String[][] { { "A", "B" }, { "C", "D" } });
		Collection<DirectedEdge<String>> r = DFSPathFinder.getInstance().find(NewGraphFromGraph.createFromDirected(g), "A", "C", null);
		Assert.assertNull(r);
	}

}
