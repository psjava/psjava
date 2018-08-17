package org.psjava.algo.graph.dfs;

import org.psjava.GraphV2;
import org.psjava.UnweightedGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.util.VisitorStopper;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class SingleSourceDFS {

    // TODO inline
    @Deprecated
    public static <V, E extends DirectedEdge<V>> void traverse(Graph<V, E> adj, V start, DFSVisitor<V, E> visitor) {
        Map<V, DFSStatus> map = new HashMap<>();
        DFSCore.traverse(start, adj::getEdges, DirectedEdge::to, map::get, map::put, visitor);
    }

    // TODO make public manual
    public static <V> void traverse(UnweightedGraph<V> unweightedGraph, V start, final Consumer<V> onDiscover, final Consumer<V> onFinish) {
        traverse(unweightedGraph.graph, start, onDiscover, onFinish);
    }

    private static <V> void traverse(GraphV2<V, V> graph, V start, Consumer<V> onDiscover, Consumer<V> onFinish) {
        Map<V, DFSStatus> map = new HashMap<>();
        DFSCore.traverse(start, v -> graph.edgeMap.get(v), v -> v, map::get, map::put, new DFSVisitorBase<V, V>() {
            @Override
            public void onDiscovered(V vertex, int depth, VisitorStopper stopper) {
                onDiscover.accept(vertex);
            }

            @Override
            public void onFinish(V vertex) {
                onFinish.accept(vertex);
            }
        });
    }

}
