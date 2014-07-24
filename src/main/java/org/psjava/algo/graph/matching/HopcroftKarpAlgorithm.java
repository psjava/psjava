package org.psjava.algo.graph.matching;

import org.psjava.algo.graph.bfs.BFS;
import org.psjava.algo.graph.bfs.BFSVisitor;
import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.MultiSourceDFS;
import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.FirstInArray;
import org.psjava.ds.array.LastInArray;
import org.psjava.ds.graph.AdjacencyList;
import org.psjava.ds.graph.AdjacencyListFromGraph;
import org.psjava.ds.graph.BipartiteGraph;
import org.psjava.ds.graph.BipartiteGraphEdge;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.EdgeFilteredSubAdjacencyList;
import org.psjava.ds.graph.MutableGraph;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.ValuesInMap;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.util.DataFilter;
import org.psjava.util.FilteredIterable;
import org.psjava.util.VisitorStopper;
import org.psjava.util.ZeroTo;

/**
 * O(V*root(E))
 */

public class HopcroftKarpAlgorithm {

	public static MaximumBipartiteMatching getInstance() {
		return new MaximumBipartiteMatching() {
			@Override
			public <V> MaximumBipartiteMatchingResult<V> calc(BipartiteGraph<V> bg) {
				AdjacencyList<Vertex<V>, Edge<V>> adj = wrapAsGraph(bg);
				while (true) {
					Object bfsMark = new Object();
					Collection<Vertex<V>> bfsFinishes = bfs(adj, bfsMark);
					if (bfsFinishes.isEmpty())
						break;
					dfs(adj, bfsFinishes, bfsMark);
				}
				return createResult(adj);
			}

		};
	}

	private static enum Side {
		LEFT, RIGHT
	}

	private static class Vertex<V> {
		V original;
		Side side;
		boolean free = true;

		Vertex(V original, Side side) {
			this.original = original;
			this.side = side;
		}
	}

	private static class EdgeStatus {
		boolean inMatch = false;
		Object bfsMark = null;
	}

	private static class Edge<V> implements DirectedEdge<Vertex<V>> {
		final Vertex<V> from, to;
		final EdgeStatus status;

		Edge(Vertex<V> from, Vertex<V> to, EdgeStatus status) {
			this.from = from;
			this.to = to;
			this.status = status;
		}

		@Override
		public Vertex<V> from() {
			return from;
		}

		@Override
		public Vertex<V> to() {
			return to;
		}

	}

	private static <V> AdjacencyList<Vertex<V>, Edge<V>> wrapAsGraph(BipartiteGraph<V> bg) {
		MutableMap<V, Vertex<V>> vertex = GoodMutableMapFactory.getInstance().create();
		for (V v : bg.getLeftVertices())
			vertex.addOrReplace(v, new Vertex<V>(v, Side.LEFT));
		for (V v : bg.getRightVertices())
			vertex.addOrReplace(v, new Vertex<V>(v, Side.RIGHT));
		MutableGraph<Vertex<V>, Edge<V>> graph = MutableGraph.create();
		for (Vertex<V> v : ValuesInMap.get(vertex))
			graph.insertVertex(v);
		for (BipartiteGraphEdge<V> e : bg.getEdges()) {
			EdgeStatus status = new EdgeStatus();
			graph.addEdge(new Edge<V>(vertex.get(e.left()), vertex.get(e.right()), status));
			graph.addEdge(new Edge<V>(vertex.get(e.right()), vertex.get(e.left()), status));
		}
		return AdjacencyListFromGraph.create(graph);
	}

	private static <V> Collection<Vertex<V>> bfs(final AdjacencyList<Vertex<V>, Edge<V>> adj, final Object mark) {
		final DynamicArray<Vertex<V>> finishes = DynamicArray.create();

		BFS.traverse(EdgeFilteredSubAdjacencyList.wrap(adj, new DataFilter<Edge<V>>() {
			@Override
			public boolean isAccepted(Edge<V> edge) {
				// to alternate matched and non-matched edges.
				if (edge.from.side == Side.LEFT)
					return !edge.status.inMatch;
				else
					return edge.status.inMatch;
			}
		}), FilteredIterable.create(adj.getVertices(), new DataFilter<Vertex<V>>() {
			@Override
			public boolean isAccepted(Vertex<V> v) {
				return (v.side == Side.LEFT) && v.free;
			}
		}), new BFSVisitor<Vertex<V>, Edge<V>>() {
			int finishDepth = -1;

			@Override
			public void onDiscover(Vertex<V> vertex, int depth, VisitorStopper stopper) {
				if (finishDepth == -1 || depth <= finishDepth) {
					if (vertex.side == Side.RIGHT && vertex.free) {
						finishDepth = depth;
						finishes.addToLast(vertex);
					}
				} else {
					stopper.stop();
				}
			}

			@Override
			public void onWalk(Edge<V> e) {
				e.status.bfsMark = mark;
			}

		});
		return finishes;
	}

	private static <V> void dfs(final AdjacencyList<Vertex<V>, Edge<V>> adj, final Collection<Vertex<V>> bfsFinishes, final Object bfsMark) {
		MultiSourceDFS.traverse(EdgeFilteredSubAdjacencyList.wrap(adj, new DataFilter<Edge<V>>() {
			@Override
			public boolean isAccepted(Edge<V> edge) {
				return edge.status.bfsMark == bfsMark; // uses only edges discovered in bfs step.
			}
		}), bfsFinishes, new DFSVisitorBase<Vertex<V>, Edge<V>>() {
			DynamicArray<Edge<V>> path = DynamicArray.create();

			@Override
			public void onWalkDown(Edge<V> edge) {
				path.addToLast(edge);
			}

			@Override
			public void onWalkUp(Edge<V> downedEdge) {
				path.removeLast();
			}

			@Override
			public void onDiscovered(Vertex<V> v, int depth, VisitorStopper stopper) {
				if (wasBfsStart(v)) {
					for (int index : ZeroTo.get(path.size()))
						path.get(index).status.inMatch = (index % 2 == 0);
					FirstInArray.getFirst(path).from.free = false;
					LastInArray.getLast(path).to.free = false;
				}
			}

			private boolean wasBfsStart(Vertex<V> v) {
				return v.side == Side.LEFT && v.free;
			}

		});
	}

	private static <V> MaximumBipartiteMatchingResult<V> createResult(AdjacencyList<Vertex<V>, Edge<V>> adj) {
		final MutableMap<V, V> match = GoodMutableMapFactory.getInstance().create();
		for (Vertex<V> v : adj.getVertices())
			for (Edge<V> e : adj.getEdges(v))
				if (e.status.inMatch)
					match.addOrReplace(e.from().original, e.to().original);

		return new MaximumBipartiteMatchingResult<V>() {
			@Override
			public V getMatchedVertex(V v) {
				return match.get(v);
			}

			@Override
			public int getMaxMatchCount() {
				return match.size() / 2;
			}

			@Override
			public boolean hasMatch(V v) {
				return match.containsKey(v);
			}
		};
	}

	private HopcroftKarpAlgorithm() {
	}
}
