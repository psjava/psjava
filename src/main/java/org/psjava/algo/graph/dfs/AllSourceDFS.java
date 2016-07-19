package org.psjava.algo.graph.dfs;

import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;

public class AllSourceDFS {

    /**
     * Remember that visiting order is not ordered.
     */
    public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> graph, DFSVisitor<V, E> visitor) {
        MultiSourceDFS.traverse(graph, graph.getVertices(), visitor);
    }

    private AllSourceDFS() {
    }

}
