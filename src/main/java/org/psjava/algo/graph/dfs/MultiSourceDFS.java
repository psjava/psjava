package org.psjava.algo.graph.dfs;

import org.psjava.AdjacencyList;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class MultiSourceDFS {

    @Deprecated
    public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> graph, Iterable<V> visitOrder, DFSVisitor<V, E> visitor) {
        Map<V, DFSStatus> status = new HashMap<>();
        traverse(visitOrder, graph::getEdges, DirectedEdge::to, status::get, status::put, visitor);
    }

    @Deprecated
    public static <V, E> void traverse(Iterable<V> visitOrder, AdjacencyList<V, E> adjacencyList, Function<E, V> destination, Function<V, DFSStatus> getDfsStatus, BiConsumer<V, DFSStatus> putDfsStatus, DFSVisitor<V, E> visitor) {
        for (V v : visitOrder)
            if (getDfsStatus.apply(v) == null)
                DFSCore.traverse(v, adjacencyList, destination, getDfsStatus, putDfsStatus, visitor);
    }

}
