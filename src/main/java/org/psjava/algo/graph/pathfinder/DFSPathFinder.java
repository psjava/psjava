package org.psjava.algo.graph.pathfinder;

import org.psjava.RemoveLast;
import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.SingleSourceDFSOld;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.util.VisitorStopper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DFSPathFinder {

    public static PathFinder getInstance() {
        return new PathFinder() {
            @Override
            public <V, E extends DirectedEdge<V>> Collection<E> find(Graph<V, E> adj, V start, final V end, Collection<E> def) {
                final List<E> history = new ArrayList<>();
                SingleSourceDFSOld.traverse(adj, start, new DFSVisitorBase<V, E>() {
                    @Override
                    public void onWalkDown(E outEdge) {
                        history.add(outEdge);
                    }

                    @Override
                    public void onDiscovered(V vertex, int depth, VisitorStopper stopper) {
                        if (vertex.equals(end))
                            stopper.stop();
                    }

                    @Override
                    public void onWalkUp(E edge) {
                        RemoveLast.removeLast(history);
                    }
                });
                if (history.isEmpty())
                    return def;
                return history;
            }

        };
    }

}
