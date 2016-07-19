package org.psjava.algo.graph;

import org.psjava.algo.graph.dfs.AllSourceDFS;
import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.util.DataKeeper;

public class CycleDetection {

    public static <V, E extends DirectedEdge<V>> boolean hasCycle(Graph<V, E> graph) {
        final DataKeeper<Boolean> found = DataKeeper.create(false);
        AllSourceDFS.traverse(graph, new DFSVisitorBase<V, E>() {
            @Override
            public void onBackEdgeFound(E edge) {
                found.set(true);
            }
        });
        return found.get();
    }

    private CycleDetection() {
    }

}
