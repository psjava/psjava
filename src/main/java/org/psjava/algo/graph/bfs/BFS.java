package org.psjava.algo.graph.bfs;

import org.psjava.ds.graph.AdjacencyList;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.queue.Queue;
import org.psjava.ds.queue.QueueFactory;
import org.psjava.ds.set.MutableSet;
import org.psjava.ds.set.MutableSetFactory;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.goods.GoodQueueFactory;

/**
 * Implementation of Breadth-first search
 * 
 * http://en.wikipedia.org/wiki/Breadth-first_search
 */

public class BFS {

	private static final QueueFactory QF = GoodQueueFactory.getInstance();
	private static final MutableSetFactory SF = GoodMutableSetFactory.getInstance();

	private static class QueueItem<V> {
		int depth;
		V v;

		QueueItem(int depth, V v) {
			this.depth = depth;
			this.v = v;
		}
	}

	public static <V, E extends DirectedEdge<V>> void traverse(AdjacencyList<V, E> adj, Iterable<V> starts, BFSVisitor<V, E> visitor) {
		MutableSet<V> discovered = SF.create();
		SimpleStopper stopper = new SimpleStopper();
		Queue<QueueItem<V>> queue = QF.create();
		for (V v : starts) {
			queue.enque(new QueueItem<V>(0, v));
			discovered.insert(v);
			visitor.onDiscover(v, 0, stopper);
			if (stopper.isStopped())
				break;
		}

		while (!queue.isEmpty() && !stopper.isStopped()) {
			QueueItem<V> cur = queue.deque();
			for (E edge : adj.getEdges(cur.v)) {
				V nextv = edge.to();
				if (!discovered.contains(nextv)) {
					discovered.insert(nextv);
					visitor.onWalk(edge);
					visitor.onDiscover(nextv, cur.depth + 1, stopper);
					if (stopper.isStopped())
						break;
					queue.enque(new QueueItem<V>(cur.depth + 1, nextv));
				}
			}
		}
	}

}