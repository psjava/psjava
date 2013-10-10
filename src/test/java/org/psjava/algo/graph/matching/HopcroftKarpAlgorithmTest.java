package org.psjava.algo.graph.matching;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.graph.MutableBipartiteGraph;

public class HopcroftKarpAlgorithmTest {

	@Test
	public void testCLRS() {
		MutableBipartiteGraph<Integer> g = MutableBipartiteGraph.create();
		int[][] d = { { 0, 5 }, { 1, 5 }, { 1, 7 }, { 2, 6 }, { 2, 7 }, { 2, 8 }, { 3, 7 }, { 4, 7 } };
		for (int[] subd : d) {
			g.insertLeftVertex(subd[0]);
			g.insertRightVertex(subd[1]);
			g.addEdge(subd[0], subd[1]);
		}

		MaximumBipartiteMatchingResult<Integer> r = HopcroftKarpAlgorithm.getInstance().calc(g);
		Assert.assertEquals(3, r.getMaxMatchCount());

		Set<Integer> rightSet = new TreeSet<Integer>();
		for (int left : g.getLeftVertices()) 
			if(r.hasMatch(left))
				rightSet.add(r.getMatchedVertex(left));
		Assert.assertEquals(3, rightSet.size());
	}

}
