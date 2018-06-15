package org.psjava.ds.graph;

import java.util.Collection;

public class SimpleDirectedGraph<V, E extends DirectedEdge<V>> implements Graph<V, E> {

    public static <V, E extends DirectedEdge<V>> SimpleDirectedGraph<V, E> create() {
        return new SimpleDirectedGraph<V, E>();
    }

    private MutableGraph<V, E> graph = MutableGraph.create();

    public void insertVertex(V v) {
        graph.insertVertex(v);
    }

    public void addEdge(E edge) {
        graph.addEdge(edge.from(), edge);
    }

    @Override
    public Collection<V> getVertices() {
        return graph.getVertices();
    }

    @Override
    public Iterable<E> getEdges(V v) {
        return graph.getEdges(v);
    }

    @Override
    public String toString() {
        return graph.toString();
    }

}
