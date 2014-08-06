package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.AllEdgeInGraph;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.ds.numbersystrem.InfinitableAddableNumberSystem;
import org.psjava.util.AssertStatus;

public class BellmanFordAlgorithm implements SingleSourceShortestPathAlgorithm {

	public static BellmanFordAlgorithm getInstance() {
		return new BellmanFordAlgorithm();
	}

	private BellmanFordAlgorithm() {
	}

	@Override
	public <V, W, E extends DirectedWeightedEdge<V, W>> SingleSourceShortestPathResult<V, W, E> calc(Graph<V, E> graph, V from, AddableNumberSystem<W> weightSystem) {
		InfinitableAddableNumberSystem<W> ns = InfinitableAddableNumberSystem.wrap(weightSystem);
		SingleSourceShortestPathCalcStatus<V, W, E> status = createInitialStatus(graph, from, ns);
		relaxEnough(graph, status, ns);
		relaxToCheckNegativeCycle(graph, ns, status);
		return SingleSourceShortestPathResultFactory.create(from, status.distance, status.previous);
	}

	public static <V, E, W> SingleSourceShortestPathCalcStatus<V, W, E> createInitialStatus(Graph<V, E> graph, V from, InfinitableAddableNumberSystem<W> ns) {
		SingleSourceShortestPathCalcStatus<V, W, E> status = new SingleSourceShortestPathCalcStatus<V, W, E>();
		for (V v : graph.getVertices())
			status.distance.add(v, ns.getInfinity());
		status.distance.replace(from, ns.getZero());
		return status;
	}

	public static <V, W, E extends DirectedWeightedEdge<V, W>> void relaxEnough(Graph<V, E> graph, SingleSourceShortestPathCalcStatus<V, W, E> status, InfinitableAddableNumberSystem<W> ns) {
		for (int i = 0; i < graph.getVertices().size() - 1; i++)
			for (E e : AllEdgeInGraph.wrap(graph))
				Relax.relax(status.distance, status.previous, e, ns);
	}

	private static <V, W, E extends DirectedWeightedEdge<V, W>> void relaxToCheckNegativeCycle(Graph<V, E> graph, InfinitableAddableNumberSystem<W> ns, SingleSourceShortestPathCalcStatus<V, W, E> status) {
		for (E e : AllEdgeInGraph.wrap(graph)) {
			boolean relaxed = Relax.relax(status.distance, status.previous, e, ns);
			AssertStatus.assertTrue(!relaxed, "contains negative cycle");
		}
	}

}
