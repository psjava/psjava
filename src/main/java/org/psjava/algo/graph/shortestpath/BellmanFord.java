package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.DirectedWeightedGraph;
import org.psjava.javautil.AssertStatus;
import org.psjava.math.ns.AddableNumberSystem;

public class BellmanFord implements SingleSourceShortestPath {

	@Override
	public <V, W> SingleSourceShortestPathResult<V, W> calc(DirectedWeightedGraph<V, W> graph, final V from, AddableNumberSystem<W> ns) {
		SingleSourceShortestPathCalcStatus<V, W> status = createInitialStatus(graph, from, ns);
		relaxEnough(graph, status, ns);
		relaxToCheckNegativeCycle(graph, ns, status);
		return SingleSourceShortestPathResultFactory.create(from, status.distance, status.previous);
	}

	public static <V, W> SingleSourceShortestPathCalcStatus<V, W> createInitialStatus(DirectedWeightedGraph<V, W> graph, final V from, AddableNumberSystem<W> ns) {
		SingleSourceShortestPathCalcStatus<V, W> status = new SingleSourceShortestPathCalcStatus<V, W>();
		for (V v : graph.getVertices())
			status.distance.put(v, null);
		status.distance.put(from, ns.getZero());
		return status;
	}

	public static <V, W> void relaxEnough(DirectedWeightedGraph<V, W> graph, SingleSourceShortestPathCalcStatus<V, W> status, AddableNumberSystem<W> ns) {
		for (int i = 0; i < graph.getVertices().size() - 1; i++)
			for (DirectedWeightedEdge<V, W> e : graph.getEdges())
				Relax.relax(status.distance, status.previous, e, ns);
	}

	private static <V, W> void relaxToCheckNegativeCycle(DirectedWeightedGraph<V, W> graph, AddableNumberSystem<W> ns, SingleSourceShortestPathCalcStatus<V, W> status) {
		for (DirectedWeightedEdge<V, W> e : graph.getEdges()) {
			boolean relaxed = Relax.relax(status.distance, status.previous, e, ns);
			AssertStatus.assertTrue(!relaxed, "contains negative cycle");
		}
	}

}
