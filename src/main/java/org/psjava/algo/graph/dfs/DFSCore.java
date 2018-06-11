package org.psjava.algo.graph.dfs;

import org.psjava.AdjacencyList;
import org.psjava.DFSStatusMap;
import org.psjava.algo.graph.bfs.SimpleStopper;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.function.Function;

public class DFSCore {

    private static class StackItem<V, E> {
        public V v;
        public E e;
        public int depth;
        Iterator<E> iter;

        StackItem(V v, E e, int d, Iterator<E> iter) {
            this.v = v;
            this.e = e;
            this.depth = d;
            this.iter = iter;
        }
    }

    public static <V, E> void traverse(AdjacencyList<V, E> adj, Function<E, V> destination, DFSStatusMap<V> status, V start, DFSVisitor<V, E> visitor) {
        Deque<StackItem<V, E>> stack = new ArrayDeque<>();
        status.set(start, DFSStatus.DISCOVERED);
        SimpleStopper stopper = new SimpleStopper();
        visitor.onDiscovered(start, 0, stopper);
        Iterator<E> iterator = adj.get(start).iterator();
        stack.push(new StackItem<>(start, null, 0, iterator));

        while (!stack.isEmpty() && !stopper.isStopped()) {
            StackItem<V, E> item = stack.peekLast();

            if (item.iter.hasNext()) {
                E edge = item.iter.next();
                V dest = destination.apply(edge);
                DFSStatus destStatus = status.get(dest);
                if (destStatus == DFSStatus.NOT_DISCOVERED) {
                    visitor.onWalkDown(edge);
                    status.set(item.v, DFSStatus.DISCOVERED);
                    visitor.onDiscovered(dest, item.depth + 1, stopper);
                    stack.addLast(new StackItem<>(dest, edge, item.depth + 1, adj.get(dest).iterator()));
                } else if (destStatus == DFSStatus.DISCOVERED) {
                    visitor.onBackEdgeFound(edge);
                }
            } else {
                stack.pollLast();
                status.set(item.v, DFSStatus.EXPLORED);
                visitor.onFinish(item.v, item.depth);
                if (item.e != null)
                    visitor.onWalkUp(item.e);
            }
        }
    }

}
