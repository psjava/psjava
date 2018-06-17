package org.psjava.algo.graph.bfs;

import org.psjava.BFSCore;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;

public class BFS {

    public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> adj, Iterable<V> startVertices, BFSVisitor<V, E> visitor) {
        BFSCore.traverse(adj, startVertices, visitor);
    }

}