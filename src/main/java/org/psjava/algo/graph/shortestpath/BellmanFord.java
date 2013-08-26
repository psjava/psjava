package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.AdjacencyListableDirectedWeightedGraph;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.math.ns.AddableNumberSystem;

public class BellmanFord implements SingleSourceShortestPath {

	@Override
	public <W> SingleSourceShortestPathResult<W> calc(AdjacencyListableDirectedWeightedGraph<W> graph, final Object from, AddableNumberSystem<W> ns) {
		SingleSourceShortestPathCalcStatus<W> status = calcFinalCalcStatus(graph, from, ns);
		return SingleSourceShortestPathResultFactory.create(from, status.distance, status.previous);
	}

	public static <W> SingleSourceShortestPathCalcStatus<W> calcFinalCalcStatus(AdjacencyListableDirectedWeightedGraph<W> graph, final Object from, AddableNumberSystem<W> ns) {
		SingleSourceShortestPathCalcStatus<W> status = new SingleSourceShortestPathCalcStatus<W>();

		for (Object v : graph.getVertices())
			status.distance.put(v, null);
		status.distance.put(from, ns.getZero());

		for (int i = 0; i < graph.getVertices().size() - 1; i++)
			for (Object v : graph.getVertices())
				for (DirectedWeightedEdge<W> e : graph.getEdges(v))
					Relax.relax(status.distance, status.previous, e, ns);

		return status;
	}

}
