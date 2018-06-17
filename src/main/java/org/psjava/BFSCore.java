package org.psjava;

import org.psjava.algo.graph.bfs.BFSVisitor;
import org.psjava.algo.graph.bfs.SimpleStopper;
import org.psjava.goods.GoodSetFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.function.Function;

public class BFSCore {

    private static class QueueItem<V> {
        int depth;
        V v;

        QueueItem(int depth, V v) {
            this.depth = depth;
            this.v = v;
        }
    }

    public static <V, E> void traverse(AdjacencyList<V, E> adj, Function<E, V> destination, Iterable<V> startVertices, BFSVisitor<V, E> visitor) {
        Set<V> discovered = GoodSetFactory.getInstance().create();
        SimpleStopper stopper = new SimpleStopper();
        Deque<QueueItem<V>> queue = new ArrayDeque<>();
        for (V v : startVertices) {
            queue.addLast(new QueueItem<>(0, v));
            discovered.add(v);
            visitor.onDiscover(v, 0, stopper);
            if (stopper.isStopped())
                break;
        }

        while (!queue.isEmpty() && !stopper.isStopped()) {
            QueueItem<V> cur = queue.pollFirst();
            for (E edge : adj.get(cur.v)) {
                V dest = destination.apply(edge);
                if (!discovered.contains(dest)) {
                    discovered.add(dest);
                    visitor.onWalk(edge);
                    visitor.onDiscover(dest, cur.depth + 1, stopper);
                    if (stopper.isStopped())
                        break;
                    queue.addLast(new QueueItem<>(cur.depth + 1, dest));
                }
            }
        }
    }

}
