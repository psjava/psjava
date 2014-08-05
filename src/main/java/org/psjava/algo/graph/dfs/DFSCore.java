package org.psjava.algo.graph.dfs;

import java.util.Iterator;

import org.psjava.algo.graph.bfs.SimpleStopper;
import org.psjava.ds.Collection;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodStackFactory;
import org.psjava.ds.stack.Stack;
import org.psjava.goods.GoodMutableMapFactory;

public class DFSCore {

	private static class StackItem<V, E> {
		public V v;
		public E e;
		public int depth;
		public Iterator<E> iter;

		public StackItem(V v, E e, int d, Iterator<E> iter) {
			this.v = v;
			this.e = e;
			this.depth = d;
			this.iter = iter;
		}
	}

	public static <V> MutableMap<V, DFSStatus> createInitialStatus(Collection<V> vertices) {
		MutableMap<V, DFSStatus> r = GoodMutableMapFactory.getInstance().create();
		for (V v : vertices)
			r.add(v, DFSStatus.NOT_DISCOVERED);
		return r;
	}

	public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> adj, MutableMap<V, DFSStatus> status, V start, DFSVisitor<V, E> visitor) {
		Stack<StackItem<V, E>> stack = GoodStackFactory.getInstance().create();
		status.replace(start, DFSStatus.DISCOVERED);
		SimpleStopper stopper = new SimpleStopper();
		visitor.onDiscovered(start, 0, stopper);
		Iterator<E> iterator = adj.getEdges(start).iterator();
		stack.push(new StackItem<V, E>(start, null, 0, iterator));

		while (!stack.isEmpty() && !stopper.isStopped()) {
			StackItem<V, E> item = stack.top();

			if (item.iter.hasNext()) {
				E edge = item.iter.next();
				V nextv = edge.to();
				DFSStatus nextc = status.get(nextv);
				if (nextc == DFSStatus.NOT_DISCOVERED) {
					visitor.onWalkDown(edge);
					status.replace(item.v, DFSStatus.DISCOVERED);
					visitor.onDiscovered(nextv, item.depth + 1, stopper);
					stack.push(new StackItem<V, E>(nextv, edge, item.depth + 1, adj.getEdges(nextv).iterator()));
				} else if (nextc == DFSStatus.DISCOVERED) {
					visitor.onBackEdgeFound(edge);
				}
			} else {
				stack.pop();
				status.replace(item.v, DFSStatus.EXPLORED);
				visitor.onFinish(item.v, item.depth);
				if (item.e != null)
					visitor.onWalkUp(item.e);
			}
		}
	}

	private DFSCore() {
	}

}
