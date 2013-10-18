package org.psjava.algo.graph.pathfinder;

import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.SingleSourceDFS;
import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.graph.AdjacencyList;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.util.VisitorStopper;

public class DFSPathFinder {

	public static PathFinder getInstance() {
		return new PathFinder() {
			@Override
			public <V, E extends DirectedEdge<V>> Collection<E> find(AdjacencyList<V, E> adj, V start, final V end, Collection<E> def) {
				final DynamicArray<E> history = new DynamicArray<E>();
				SingleSourceDFS.traverse(adj, start, new DFSVisitorBase<V, E>() {
					@Override
					public void onWalkDown(E outEdge) {
						history.addToLast(outEdge);
					}

					@Override
					public void onDiscovered(V vertex, int depth, VisitorStopper stopper) {
						if (vertex.equals(end))
							stopper.stop();
					}

					@Override
					public void onWalkUp(E edge) {
						history.removeLast();
					}
				});
				if (history.isEmpty())
					return def;
				return history;
			}

		};
	}

	private DFSPathFinder() {
	}

}
