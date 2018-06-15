package org.psjava.ds.graph;

import java.util.Collection;

public class MutableUndirectedUnweightedGraph<V> implements Graph<V, UndirectedEdge<V>> {

    public static <V> MutableUndirectedUnweightedGraph<V> create() {
        return new MutableUndirectedUnweightedGraph<V>();
    }

    private final MutableUndirectedGraph<V, UndirectedEdge<V>> g = MutableUndirectedGraph.create();

    public void insertVertex(V v) {
        g.insertVertex(v);
    }

    public void addEdge(V v1, V v2) {
        g.addEdge(SimpleUndirectedEdge.create(v1, v2));
    }

    @Override
    public Collection<V> getVertices() {
        return g.getVertices();
    }

    @Override
    public Iterable<UndirectedEdge<V>> getEdges(V v) {
        return g.getEdges(v);
    }

    @Override
    public String toString() {
        return g.toString();
    }
}
