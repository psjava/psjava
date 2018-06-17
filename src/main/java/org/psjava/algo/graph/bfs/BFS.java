package org.psjava.algo.graph.bfs;

import org.psjava.BFSCore;
import org.psjava.BFSStatus;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class BFS {

    @Deprecated
    public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> adj, Iterable<V> startVertices, BFSVisitor<V, E> visitor) {
        Map<V, BFSStatus> discovered = new HashMap<>();
        Function<V, BFSStatus> getStatus = v -> discovered.getOrDefault(v, BFSStatus.NOT_DISCOVERED);
        BiConsumer<V, BFSStatus> setStatus = discovered::put;
        BFSCore.traverse(adj::getEdges, DirectedEdge::to, getStatus, setStatus, startVertices, visitor);
    }

}