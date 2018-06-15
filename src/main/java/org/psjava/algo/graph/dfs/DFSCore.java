package org.psjava.algo.graph.dfs;

import org.psjava.AdjacencyList;
import org.psjava.algo.graph.bfs.SimpleStopper;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

public class DFSCore {

    private static class StackItem<V, E> {
        final E previousEdgeOrNull;
        final V vertex;
        final int depth;
        final Iterator<E> remainEdges;

        StackItem(E previousEdgeOrNull, V vertex, int d, Iterator<E> remainEdges) {
            this.vertex = vertex;
            this.previousEdgeOrNull = previousEdgeOrNull;
            this.depth = d;
            this.remainEdges = remainEdges;
        }
    }

    public static <V, E> void traverse(AdjacencyList<V, E> adj, Function<E, V> destination, Map<V, DFSStatus> status, V start, DFSVisitor<V, E> visitor) {
        Deque<StackItem<V, E>> stack = new ArrayDeque<>();
        status.put(start, DFSStatus.DISCOVERED);
        SimpleStopper stopper = new SimpleStopper();
        visitor.onDiscovered(start, 0, stopper);
        Iterator<E> iterator = adj.get(start).iterator();
        stack.push(new StackItem<>(null, start, 0, iterator));

        while (!stack.isEmpty() && !stopper.isStopped()) {
            StackItem<V, E> item = stack.peekLast();

            if (item.remainEdges.hasNext()) {
                E edge = item.remainEdges.next();
                V dest = destination.apply(edge);
                DFSStatus destStatus = status.get(dest);
                if (destStatus == null) {
                    visitor.onWalkDown(edge);
                    status.put(item.vertex, DFSStatus.DISCOVERED);
                    visitor.onDiscovered(dest, item.depth + 1, stopper);
                    stack.addLast(new StackItem<>(edge, dest, item.depth + 1, adj.get(dest).iterator()));
                } else if (destStatus == DFSStatus.DISCOVERED) {
                    visitor.onBackEdgeFound(edge);
                }
            } else {
                stack.pollLast();
                status.put(item.vertex, DFSStatus.EXPLORED);
                visitor.onFinish(item.vertex);
                if (item.previousEdgeOrNull != null)
                    visitor.onWalkUp(item.previousEdgeOrNull);
            }
        }
    }

}
