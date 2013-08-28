package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.DirectedWeightedGraph;
import org.psjava.javautil.AssertStatus;
import org.psjava.math.ns.AddableNumberSystem;

public class BellmanFord implements SingleSourceShortestPath {

	@Override
	public <W> SingleSourceShortestPathResult<W> calc(DirectedWeightedGraph<W> graph, final Object from, AddableNumberSystem<W> ns) {
		SingleSourceShortestPathCalcStatus<W> status = createInitialStatus(graph, from, ns);
		relaxEnough(graph, status, ns);
		relaxToCheckNegativeCycle(graph, ns, status);
		return SingleSourceShortestPathResultFactory.create(from, status.distance, status.previous);
	}

	public static <W> SingleSourceShortestPathCalcStatus<W> createInitialStatus(DirectedWeightedGraph<W> graph, final Object from, AddableNumberSystem<W> ns) {
		SingleSourceShortestPathCalcStatus<W> status = new SingleSourceShortestPathCalcStatus<W>();
		for (Object v : graph.getVertices())
			status.distance.put(v, null);
		status.distance.put(from, ns.getZero());
		return status;
	}

	public static <W> void relaxEnough(DirectedWeightedGraph<W> graph, SingleSourceShortestPathCalcStatus<W> status, AddableNumberSystem<W> ns) {
		for (int i = 0; i < graph.getVertices().size() - 1; i++)
			for (DirectedWeightedEdge<W> e : graph.getEdges())
				Relax.relax(status.distance, status.previous, e, ns);
	}

	private static <W> void relaxToCheckNegativeCycle(DirectedWeightedGraph<W> graph, AddableNumberSystem<W> ns, SingleSourceShortestPathCalcStatus<W> status) {
		for (DirectedWeightedEdge<W> e : graph.getEdges()) {
			boolean relaxed = Relax.relax(status.distance, status.previous, e, ns);
			AssertStatus.assertTrue(!relaxed, "contains negative cycle");
		}
	}

}
