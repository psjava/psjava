package org.psjava.algo.graph.dfs;

import static org.junit.Assert.*;

import org.junit.Test;
import org.psjava.algo.graph.dfs.DFSVisitor;
import org.psjava.ds.graph.AdjacencyListOfDirectedGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.ds.map.MutableMap;

public class DFSCoreTest {

	String res;

	@Test
	public void testSimpleTraverseScenario() {
		Graph<String, DirectedEdge<String>> tg = TestGraphFactory.createDirected(new String[][] { { "1", "2" }, { "2", "3" }, { "3", "1" } });
		res = "";
		MutableMap<String, DFSStatus> status = DFSCore.createInitialStatus(tg);
		DFSCore.traverse(AdjacencyListOfDirectedGraph.create(tg), status, "1", new DFSVisitor<String, DirectedEdge<String>>() {
			@Override
			public void onDiscovered(String vertex, int depth) {
				res += "N" + vertex;
			}

			@Override
			public void onBackEdgeFound(DirectedEdge<String> e) {
				res += "B" + e.from() + e.to();
			}

			@Override
			public void onFinish(String vertex, int depth) {
				res += "F" + vertex;
			}

			@Override
			public void onWalkDown(DirectedEdge<String> edge) {
				res += "D" + edge.from() + edge.to();
			}

			@Override
			public void onWalkUp(DirectedEdge<String> edge) {
				res += "U" + edge.to() + edge.from();
			}
		});
		assertEquals("N1D12N2D23N3B31F3U32F2U21F1", res);
	}

}
