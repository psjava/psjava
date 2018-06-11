package org.psjava.algo.graph.dfs;

import org.psjava.util.VisitorStopper;

public class DFSVisitorBase<V, E> implements DFSVisitor<V, E> {

    @Override
    public void onDiscovered(V vertex, int depth, VisitorStopper stopper) {
    }

    @Override
    public void onFinish(V vertex) {
    }

    @Override
    public void onBackEdgeFound(E edge) {
    }

    @Override
    public void onWalkDown(E edge) {
    }

    @Override
    public void onWalkUp(E downedEdge) {
    }
}
