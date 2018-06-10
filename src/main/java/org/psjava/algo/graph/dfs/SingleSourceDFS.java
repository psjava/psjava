package org.psjava.algo.graph.dfs;

import org.psjava.AdjacencyList;
import org.psjava.DFSStatusMap;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;

import java.util.function.Function;

public class SingleSourceDFS {

    @Deprecated
    public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> adj, V start, DFSVisitor<V, E> visitor) {
        traverse(adj::getEdges, e -> e.to(), start, visitor);
    }

    public static <V, E extends DirectedEdge<V>> void traverse(AdjacencyList<V, E> adjacencyList, Function<E, V> destination, V start, DFSVisitor<V, E> visitor) {
        DFSCore.traverse(adjacencyList, destination, new DFSStatusMap<>(), start, visitor);
    }

}
