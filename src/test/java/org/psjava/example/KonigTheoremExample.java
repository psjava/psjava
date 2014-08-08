package org.psjava.example;

import junit.framework.Assert;
import org.junit.Test;
import org.psjava.algo.graph.KonigTheorem;
import org.psjava.algo.graph.MinimumVertexCoverAlgorithmInBipartiteGraph;
import org.psjava.algo.graph.matching.HopcroftKarpAlgorithm;
import org.psjava.algo.graph.matching.MaximumBipartiteMatchingResult;
import org.psjava.ds.graph.MutableBipartiteGraph;

/**
 * @implementation {@link org.psjava.algo.graph.KonigTheorem}
 *
 * @see {@link org.psjava.example.algo.MaximumBipartiteMatchingExample}
 * @see {@link org.psjava.example.algo.MinimumVertexCoverInBipartiteGraphExample}
 */
public class KonigTheoremExample {

	@Test
	public void example() {
		MutableBipartiteGraph<String> g = MutableBipartiteGraph.create();

		g.insertLeftVertex("A");
		g.insertLeftVertex("B");
		g.insertLeftVertex("C");

		g.insertRightVertex("X");
		g.insertRightVertex("Y");
		g.insertRightVertex("Z");

		g.addEdge("A", "X");
		g.addEdge("A", "Y");
		g.addEdge("A", "Z");
		g.addEdge("B", "Z");
		g.addEdge("C", "Z");

		// By Konig's Theorem, In any bipartite graph, the number of edges in a maximum matching equals the number of vertices in a minimum vertex cover.
		// So matching algorithm is used in implementation. In this example, Hopcroft-Karp algorithm is used.
		MinimumVertexCoverAlgorithmInBipartiteGraph algorithm = KonigTheorem.getInstance(HopcroftKarpAlgorithm.getInstance());

		int number = algorithm.calcMinimumVertexCover(g); // result is 2, ("A", "C")
		Assert.assertEquals(2, number);
	}

}
