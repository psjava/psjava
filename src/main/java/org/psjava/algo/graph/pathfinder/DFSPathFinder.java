package org.psjava.algo.graph.pathfinder;

import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.SingleSourceDFS;
import org.psjava.ds.Collection;
import org.psjava.ds.array.AddToLastAll;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.graph.AdjacencyList;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.util.DataKeeper;

public class DFSPathFinder implements PathFinder {
	
	// TODO stop when found.
	// TODO add unit test.

	@Override
	public <V, E extends DirectedEdge<V>> Collection<E> find(AdjacencyList<V, E> adj, V start, final V end, Collection<E> def) {
		final DataKeeper<Collection<E>> r = DataKeeper.create(def);
		SingleSourceDFS.traverse(adj, start, new DFSVisitorBase<V, E>() {
			DynamicArray<E> history = new DynamicArray<E>();

			@Override
			public void onWalkDown(E outEdge) {
				history.addToLast(outEdge);
			}

			public void onDiscovered(Object vertex, int d) {
				if (vertex.equals(end)) {
					DynamicArray<E> copy = new DynamicArray<E>();
					AddToLastAll.add(copy, history); // TODO copy is no need after stopper applied. 
					r.set(copy);
				}
			}

			@Override
			public void onWalkUp(E edge) {
				history.removeLast();
			}
		});
		return r.get();
	}

}
