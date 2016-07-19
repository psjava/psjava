package org.psjava.algo.graph.bfs;

import org.psjava.util.VisitorStopper;

public interface BFSVisitor<V, E> {
    void onDiscover(V vertex, int depth, VisitorStopper stopper);

    void onWalk(E e);
}
