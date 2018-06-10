package org.psjava.algo.graph.dfs;

import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.map.MutableMap;

import java.util.function.Function;

public class SingleSourceDFS {

    @Deprecated
    public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> adj, V start, DFSVisitor<V, E> visitor) {
        traverse(adj, e -> e.to(), start, visitor);
    }

    public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> adj, Function<E, V> destination, V start, DFSVisitor<V, E> visitor) {
        MutableMap<V, DFSStatus> status = DFSCore.createInitialStatus(adj.getVertices());
        DFSCore.traverse(adj, destination, status, start, visitor);
    }

}
