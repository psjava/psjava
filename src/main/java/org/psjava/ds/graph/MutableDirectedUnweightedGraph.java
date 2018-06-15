package org.psjava.ds.graph;

import java.util.Collection;

public class MutableDirectedUnweightedGraph<V> implements Graph<V, DirectedEdge<V>> {

    public static <V> MutableDirectedUnweightedGraph<V> create() {
        return new MutableDirectedUnweightedGraph<V>();
    }

    private SimpleDirectedGraph<V, DirectedEdge<V>> graph = SimpleDirectedGraph.create();

    public void insertVertex(V v) {
        graph.insertVertex(v);
    }

    public void addEdge(V from, V to) {
        graph.addEdge(SimpleDirectedEdge.create(from, to));
    }

    @Override
    public Collection<V> getVertices() {
        return graph.getVertices();
    }

    @Override
    public Iterable<DirectedEdge<V>> getEdges(V v) {
        return graph.getEdges(v);
    }

    @Override
    public String toString() {
        return graph.toString();
    }

}
