package org.psjava.ds.graph;

import java.util.Collection;

public class MutableUndirectedWeightedGraph<V, W> implements Graph<V, UndirectedWeightedEdge<V, W>> {

    public static <V, W> MutableUndirectedWeightedGraph<V, W> create() {
        return new MutableUndirectedWeightedGraph<V, W>();
    }

    private MutableUndirectedGraph<V, UndirectedWeightedEdge<V, W>> g = MutableUndirectedGraph.create();

    public void insertVertex(V v) {
        g.insertVertex(v);
    }

    public void addEdge(V v1, V v2, W weight) {
        g.addEdge(SimpleUndirectedWeightedEdge.create(v1, v2, weight));
    }

    @Override
    public Collection<V> getVertices() {
        return g.getVertices();
    }

    @Override
    public Iterable<UndirectedWeightedEdge<V, W>> getEdges(V v) {
        return g.getEdges(v);
    }

    @Override
    public String toString() {
        return g.toString();
    }
}
