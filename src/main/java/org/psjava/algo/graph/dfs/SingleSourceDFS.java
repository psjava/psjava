package org.psjava.algo.graph.dfs;

import org.psjava.AdjacencyList;
import org.psjava.ds.PSCollection;
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
        PSCollection<V> vertices = adj.getVertices();
        AdjacencyList<V, E> adjacencyList = adj::getEdges;
        MutableMap<V, DFSStatus> status = DFSCore.createInitialStatus(vertices);
        DFSCore.traverse(adjacencyList, destination, status, start, visitor);
    }

}
