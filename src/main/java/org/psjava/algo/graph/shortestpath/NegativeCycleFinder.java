package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.Collection;
import org.psjava.ds.Deque;
import org.psjava.ds.DoubleLinkedList;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.SingleElementCollection;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.DirectedWeightedEdgeFactory;
import org.psjava.ds.graph.DirectedWeightedGraph;
import org.psjava.ds.set.MutableSet;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.javautil.AssertStatus;
import org.psjava.javautil.MergedCollection;
import org.psjava.javautil.VarargsIterable;
import org.psjava.math.ns.AddableNumberSystem;

/**
 * This class is an application of Bellman Ford's algorithm.
 */

public class NegativeCycleFinder {

	private static final class Edge<V, W> implements DirectedWeightedEdge<Object, W> {
		private final DirectedWeightedEdge<V, W> original;

		private Edge(DirectedWeightedEdge<V, W> e) {
			this.original = e;
		}

		@Override
		public Object from() {
			return original.from();
		}

		@Override
		public Object to() {
			return original.to();
		}

		@Override
		public W weight() {
			return original.weight();
		}
	}

	private static final Object VIRTUAL_START = new Object();

	/**
	 * Finds any one of possible negative cycles in a graph.
	 */
	public static <V, W> NegativeCycleFinderResult<V, W> find(DirectedWeightedGraph<V, W> graph, AddableNumberSystem<W> ns) {
		DirectedWeightedGraph<Object, W> augmented = augment(graph, ns);
		SingleSourceShortestPathCalcStatus<Object, W> status = BellmanFord.createInitialStatus(augmented, VIRTUAL_START, ns);
		BellmanFord.relaxEnough(augmented, status, ns);
		DirectedWeightedEdge<Object, W> relaxed = relaxAnyEdgeIfPossible(augmented, ns, status);
		return createResult(status, relaxed);
	}

	private static <V, W> DirectedWeightedGraph<Object, W> augment(final DirectedWeightedGraph<V, W> original, AddableNumberSystem<W> ns) {
		final DynamicArray<DirectedWeightedEdge<Object, W>> edges = DynamicArray.create();
		for (DirectedWeightedEdge<V, W> e : original.getEdges())
			edges.addToLast(new Edge<V, W>(e));
		for (V v : original.getVertices())
			edges.addToLast(DirectedWeightedEdgeFactory.create(VIRTUAL_START, v, ns.getZero()));

		return new DirectedWeightedGraph<Object, W>() {
			@SuppressWarnings("unchecked")
			@Override
			public Collection<Object> getVertices() {
				return MergedCollection.wrap(VarargsIterable.create(SingleElementCollection.create(VIRTUAL_START), original.getVertices()));
			}

			@Override
			public Iterable<DirectedWeightedEdge<Object, W>> getEdges() {
				return edges;
			}
		};
	}

	private static <V, W> DirectedWeightedEdge<V, W> relaxAnyEdgeIfPossible(DirectedWeightedGraph<V, W> graph, AddableNumberSystem<W> ns, SingleSourceShortestPathCalcStatus<V, W> status) {
		for (DirectedWeightedEdge<V, W> e : graph.getEdges())
			if (Relax.relax(status.distance, status.previous, e, ns))
				return e;
		return null;
	}

	private static <V, W> NegativeCycleFinderResult<V, W> createResult(final SingleSourceShortestPathCalcStatus<Object, W> status, final DirectedWeightedEdge<Object, W> lastRelaxedEdgeOrNull) {
		return new NegativeCycleFinderResult<V, W>() {
			@Override
			public boolean hasCycle() {
				return lastRelaxedEdgeOrNull != null;
			}

			@SuppressWarnings("unchecked")
			@Override
			public Collection<DirectedWeightedEdge<V, W>> getPath() {
				AssertStatus.assertTrue(hasCycle(), "no cycle");
				MutableSet<Object> visited = GoodMutableSetFactory.getInstance().create();
				Deque<DirectedWeightedEdge<V, W>> path = DoubleLinkedList.create();
				DirectedWeightedEdge<Object, W> curEdge = lastRelaxedEdgeOrNull;
				while (true) {
					path.addToFirst(((Edge<V, W>) curEdge).original);
					visited.insert(curEdge.to());
					if (visited.contains(curEdge.from()))
						break;
					curEdge = status.previous.get(curEdge.from());
				}
				while (!path.getLast().to().equals(curEdge.from()))
					path.removeLast();
				return path;
			}
		};
	}

}
