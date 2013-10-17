package org.psjava.algo.graph.pathfinder;

import org.psjava.algo.graph.bfs.BFS;
import org.psjava.algo.graph.bfs.BFSStopper;
import org.psjava.algo.graph.bfs.BFSVisitor;
import org.psjava.ds.Collection;
import org.psjava.ds.deque.Deque;
import org.psjava.ds.deque.DoubleLinkedList;
import org.psjava.ds.graph.AdjacencyList;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.util.SingleElementCollection;

public class BFSPathFinder {

	public static PathFinder getInstance() {
		return new PathFinder() {
			@Override
			public <V, E extends DirectedEdge<V>> Collection<E> find(AdjacencyList<V, E> adj, V start, final V target, Collection<E> def) {
				final MutableMap<V, E> walked = GoodMutableMapFactory.getInstance().create();
				BFS.traverse(adj, SingleElementCollection.create(start), new BFSVisitor<V, E>() {
					@Override
					public void onDiscover(V vertex, int d, BFSStopper s) {
						if (vertex.equals(target))
							s.stop();
					}

					@Override
					public void onWalk(E e) {
						walked.put(e.to(), e);
					}
				});
				if (!walked.containsKey(target))
					return def;
				return extractPath(target, walked);
			}

		};
	}

	private static <V, E extends DirectedEdge<V>> Collection<E> extractPath(final V target, final MutableMap<V, E> walked) {
		Deque<E> q = DoubleLinkedList.create();
		V cur = target;
		while (walked.containsKey(cur)) {
			E e = walked.get(cur);
			q.addToFirst(e);
			cur = e.from();
		}
		return q;
	}
}
