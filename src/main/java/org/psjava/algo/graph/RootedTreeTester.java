package org.psjava.algo.graph;

import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.SingleSourceDFSOld;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.util.DataKeeper;
import org.psjava.util.VisitorStopper;

public class RootedTreeTester {

    public static <E extends DirectedEdge<V>, V> boolean is(Graph<V, E> graph, V root) {
        if (CycleDetection.hasCycle(graph))
            return false;
        final DataKeeper<Integer> visitCount = DataKeeper.create(0);
        SingleSourceDFSOld.traverse(graph, root, new DFSVisitorBase<V, E>() {
            @Override
            public void onDiscovered(V vertex, int depth, VisitorStopper stopper) {
                visitCount.set(visitCount.get() + 1);
            }
        });
        return visitCount.get() == graph.getVertices().size();
    }

    private RootedTreeTester() {
    }

}
