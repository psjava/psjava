package org.psjava.algo.graph.dfs;

import org.psjava.util.VisitorStopper;

public interface DFSVisitor<V, E> {
    // TODO depth may be trackable by user.
    void onDiscovered(V vertex, int depth, VisitorStopper stopper);

    void onFinish(V vertex);

    void onBackEdgeFound(E edge);

    void onWalkDown(E edge);

    void onWalkUp(E downedEdge);
}