package org.psjava.algo.graph.dfs;

import org.psjava.AdjacencyList;
import org.psjava.algo.graph.bfs.SimpleStopper;
import org.psjava.ds.PSCollection;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;

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

    public static <V> MutableMap<V, DFSStatus> createInitialStatus(PSCollection<V> vertices) {
        MutableMap<V, DFSStatus> r = GoodMutableMapFactory.getInstance().create();
        for (V v : vertices)
            r.add(v, DFSStatus.NOT_DISCOVERED); // TODO let empty as not discovered then vertices is not required
        return r;
    }

    public static <V, E> void traverse(AdjacencyList<V, E> adj, Function<E, V> destination, MutableMap<V, DFSStatus> status, V start, DFSVisitor<V, E> visitor) {
        Deque<StackItem<V, E>> stack = new ArrayDeque<>();
        status.replace(start, DFSStatus.DISCOVERED);
        SimpleStopper stopper = new SimpleStopper();
        visitor.onDiscovered(start, 0, stopper);
        Iterator<E> iterator = adj.get(start).iterator();
        stack.push(new StackItem<>(start, null, 0, iterator));

        while (!stack.isEmpty() && !stopper.isStopped()) {
            StackItem<V, E> item = stack.peekLast();

            if (item.iter.hasNext()) {
                E edge = item.iter.next();
                V nextv = destination.apply(edge);
                DFSStatus nextc = status.get(nextv);
                if (nextc == DFSStatus.NOT_DISCOVERED) {
                    visitor.onWalkDown(edge);
                    status.replace(item.v, DFSStatus.DISCOVERED);
                    visitor.onDiscovered(nextv, item.depth + 1, stopper);
                    stack.addLast(new StackItem<>(nextv, edge, item.depth + 1, adj.get(nextv).iterator()));
                } else if (nextc == DFSStatus.DISCOVERED) {
                    visitor.onBackEdgeFound(edge);
                }
            } else {
                stack.pollLast();
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
