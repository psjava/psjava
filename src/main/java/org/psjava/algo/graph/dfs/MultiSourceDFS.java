package org.psjava.algo.graph.dfs;

import org.psjava.AdjacencyList;
import org.psjava.DFSStatusMap;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;

import java.util.function.Function;

public class MultiSourceDFS {

    @Deprecated
    public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> graph, Iterable<V> visitOrder, DFSVisitor<V, E> visitor) {
        traverse(graph::getEdges, DirectedEdge::to, visitOrder, visitor);
    }

    public static <V, E> void traverse(AdjacencyList<V, E> adjacencyList, Function<E, V> destination, Iterable<V> visitOrder, DFSVisitor<V, E> visitor) {
        DFSStatusMap<V> status = new DFSStatusMap<>();
        for (V v : visitOrder)
            if (status.get(v) == DFSStatus.NOT_DISCOVERED)
                DFSCore.traverse(adjacencyList, destination, status, v, visitor);
    }

}
