package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.util.AssertStatus;

public class BellmanFord implements SingleSourceShortestPath {

	@Override
	public <V, W, E extends DirectedWeightedEdge<V, W>> SingleSourceShortestPathResult<V, W, E> calc(Graph<V, E> graph, V from, AddableNumberSystem<W> ns) {
		SingleSourceShortestPathCalcStatus<V, W, E> status = createInitialStatus(graph, from, ns);
		relaxEnough(graph, status, ns);
		relaxToCheckNegativeCycle(graph, ns, status);
		return SingleSourceShortestPathResultFactory.create(from, status.distance, status.previous);
	}

	public static <V, E, W> SingleSourceShortestPathCalcStatus<V, W, E> createInitialStatus(Graph<V, E> graph, final V from, AddableNumberSystem<W> ns) {
		SingleSourceShortestPathCalcStatus<V, W, E> status = new SingleSourceShortestPathCalcStatus<V, W, E>();
		for (V v : graph.getVertices())
			status.distance.addOrReplace(v, null);
		status.distance.addOrReplace(from, ns.getZero());
		return status;
	}

	public static <V, W, E extends DirectedWeightedEdge<V, W>> void relaxEnough(Graph<V, E> graph, SingleSourceShortestPathCalcStatus<V, W, E> status, AddableNumberSystem<W> ns) {
		for (int i = 0; i < graph.getVertices().size() - 1; i++)
			for (E e : graph.getEdges())
				Relax.relax(status.distance, status.previous, e, ns);
	}

	private static <V, W, E extends DirectedWeightedEdge<V, W>> void relaxToCheckNegativeCycle(Graph<V, E> graph, AddableNumberSystem<W> ns, SingleSourceShortestPathCalcStatus<V, W, E> status) {
		for (E e : graph.getEdges()) {
			boolean relaxed = Relax.relax(status.distance, status.previous, e, ns);
			AssertStatus.assertTrue(!relaxed, "contains negative cycle");
		}
	}

	public BellmanFord() {
	}

}
