package org.psjava.algo.graph.dfs;

import org.psjava.AdjacencyList;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SingleSourceDFS {

    @Deprecated
    public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> adj, V start, DFSVisitor<V, E> visitor) {
        traverse(adj::getEdges, DirectedEdge::to, start, visitor);
    }

    @Deprecated
    public static <V, E> void traverse(AdjacencyList<V, E> adjacencyList, Function<E, V> destination, V start, DFSVisitor<V, E> visitor) {
        Map<V, DFSStatus> map = new HashMap<>();
        DFSCore.traverse(start, adjacencyList, destination, map::get, map::put, visitor);
    }

}
