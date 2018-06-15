package org.psjava.algo.graph.dfs;

import org.psjava.AdjacencyList;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MultiSourceDFS {

    @Deprecated
    public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> graph, Iterable<V> visitOrder, DFSVisitor<V, E> visitor) {
        traverse(graph::getEdges, DirectedEdge::to, visitOrder, visitor);
    }

    public static <V, E> void traverse(AdjacencyList<V, E> adjacencyList, Function<E, V> destination, Iterable<V> visitOrder, DFSVisitor<V, E> visitor) {
        Map<V, DFSStatus> status = new HashMap<>();
        for (V v : visitOrder)
            if (status.get(v) == null)
                DFSCore.traverse(adjacencyList, destination, status, v, visitor);
    }

}
