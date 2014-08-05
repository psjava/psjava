package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.OldGraph;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.util.AssertStatus;

public class BellmanFordAlgorithm implements SingleSourceShortestPathAlgorithm {

	public static BellmanFordAlgorithm getInstance() {
		return new BellmanFordAlgorithm();
	}

	private BellmanFordAlgorithm() {
	}

	@Override
	public <V, W, E extends DirectedWeightedEdge<V, W>> SingleSourceShortestPathResult<V, W, E> calc(OldGraph<V, E> oldGraph, V from, AddableNumberSystem<W> ns) {
		SingleSourceShortestPathCalcStatus<V, W, E> status = createInitialStatus(oldGraph, from, ns);
		relaxEnough(oldGraph, status, ns);
		relaxToCheckNegativeCycle(oldGraph, ns, status);
		return SingleSourceShortestPathResultFactory.create(from, status.distance, status.previous);
	}

	public static <V, E, W> SingleSourceShortestPathCalcStatus<V, W, E> createInitialStatus(OldGraph<V, E> oldGraph, final V from, AddableNumberSystem<W> ns) {
		SingleSourceShortestPathCalcStatus<V, W, E> status = new SingleSourceShortestPathCalcStatus<V, W, E>();
		for (V v : oldGraph.getVertices())
			status.distance.add(v, null);
		status.distance.replace(from, ns.getZero());
		return status;
	}

	public static <V, W, E extends DirectedWeightedEdge<V, W>> void relaxEnough(OldGraph<V, E> oldGraph, SingleSourceShortestPathCalcStatus<V, W, E> status, AddableNumberSystem<W> ns) {
		for (int i = 0; i < oldGraph.getVertices().size() - 1; i++)
			for (E e : oldGraph.getEdges())
				Relax.relax(status.distance, status.previous, e, ns);
	}

	private static <V, W, E extends DirectedWeightedEdge<V, W>> void relaxToCheckNegativeCycle(OldGraph<V, E> oldGraph, AddableNumberSystem<W> ns, SingleSourceShortestPathCalcStatus<V, W, E> status) {
		for (E e : oldGraph.getEdges()) {
			boolean relaxed = Relax.relax(status.distance, status.previous, e, ns);
			AssertStatus.assertTrue(!relaxed, "contains negative cycle");
		}
	}

}
