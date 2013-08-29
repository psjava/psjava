package org.psjava.algo.graph.shortestpath;

import java.util.LinkedList;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.DirectedWeightedGraph;
import org.psjava.ds.graph.MergedGraph;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.javautil.AssertStatus;
import org.psjava.math.ns.AddableNumberSystem;

public class NegativeCycleFinder {

	/**
	 * This class is an application of Bellman Ford's algorithm.
	 */

	private static final Object VIRTUAL_START = new Object();

	public static <W> NegativeCycleFinderResult<W> find(DirectedWeightedGraph<W> graph, AddableNumberSystem<W> ns) {
		DirectedWeightedGraph<W> augmented = augment(graph, ns);
		SingleSourceShortestPathCalcStatus<W> status = BellmanFord.createInitialStatus(augmented, VIRTUAL_START, ns);
		BellmanFord.relaxEnough(augmented, status, ns);
		DirectedWeightedEdge<W> relaxed = relaxAnyEdgeIfPossible(graph, ns, status);
		return createResult(status, relaxed);
	}

	private static <W> DirectedWeightedGraph<W> augment(DirectedWeightedGraph<W> original, AddableNumberSystem<W> ns) {
		MutableDirectedWeightedGraph<W> addition = MutableDirectedWeightedGraph.create();
		addition.insertVertex(VIRTUAL_START);
		for (Object v : original.getVertices()) {
			addition.insertVertex(v);
			addition.addEdge(VIRTUAL_START, v, ns.getZero());
		}
		return MergedGraph.create(original, addition);
	}

	private static <W> DirectedWeightedEdge<W> relaxAnyEdgeIfPossible(DirectedWeightedGraph<W> graph, AddableNumberSystem<W> ns, SingleSourceShortestPathCalcStatus<W> status) {
		for (DirectedWeightedEdge<W> e : graph.getEdges())
			if (Relax.relax(status.distance, status.previous, e, ns))
				return e;
		return null;
	}

	private static <W> NegativeCycleFinderResult<W> createResult(final SingleSourceShortestPathCalcStatus<W> status, final DirectedWeightedEdge<W> lastRelaxedEdgeOrNull) {
		return new NegativeCycleFinderResult<W>() {
			@Override
			public boolean hasCycle() {
				return lastRelaxedEdgeOrNull != null;
			}

			@Override
			public Iterable<DirectedWeightedEdge<W>> getPath() {
				AssertStatus.assertTrue(hasCycle(), "no cycle");
				LinkedList<DirectedWeightedEdge<W>> path = new LinkedList<DirectedWeightedEdge<W>>();
				// from vertex is always in a cycle.
				Object cur = lastRelaxedEdgeOrNull.from();
				while (true) {
					DirectedWeightedEdge<W> edge = status.previous.get(cur);
					path.addFirst(edge);
					if (edge.from().equals(lastRelaxedEdgeOrNull.from()))
						break;
					cur = edge.from();
				}
				return path;
			}
		};
	}

}
