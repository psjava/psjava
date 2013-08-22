package org.psjava.algo.graph.shortestpath;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.graph.shortestpath.Dijkstra;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPath;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.DirectedWeightedEdgeFactory;
import org.psjava.ds.graph.MutableDirectedGraph;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.math.ns.IntegerNumberSystem;



public class DijkstraTest {
	
	private static final Dijkstra ALGO = new Dijkstra(new BinaryHeapFactory());

	protected SingleSourceShortestPath getAlgorithm() {
		return new Dijkstra(new BinaryHeapFactory());
	}
	
	@Test
	public void testNotReachableCompoment() {
		MutableDirectedGraph<DirectedWeightedEdge<Integer>> g = new MutableDirectedGraph<DirectedWeightedEdge<Integer>>();
		g.insertVertex("A");
		g.insertVertex("B");
		g.insertVertex("C");
		g.addEdge(DirectedWeightedEdgeFactory.create("B", "C", 1));
		SingleSourceShortestPathResult<Integer, DirectedWeightedEdge<Integer>> r = ALGO.calc(g, "A", IntegerNumberSystem.getInstance());
		Assert.assertFalse(r.isReachable("B"));
	}


}
