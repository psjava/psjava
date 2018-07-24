package org.psjava.ds.graph;

import org.psjava.util.Assertion;

import java.util.Collection;

public class MutableUndirectedGraph<V, E extends UndirectedEdge<V>> implements Graph<V, E> {

    public static <V, E extends UndirectedEdge<V>> MutableUndirectedGraph<V, E> create() {
        return new MutableUndirectedGraph<V, E>();
    }

    private MutableGraph<V, E> g = MutableGraph.create();

    public void insertVertex(V v) {
        g.insertVertex(v);
    }

    public void addEdge(E e) {
        assertVertexExist(e.v1());
        assertVertexExist(e.v2());
        g.addEdge(e.v1(), e);
        g.addEdge(e.v2(), e);
    }

    private void assertVertexExist(V v) {
        Assertion.ensure(g.getVertices().contains(v), "vertex is not in graph");
    }

    @Override
    public Collection<V> getVertices() {
        return g.getVertices();
    }

    @Override
    public Iterable<E> getEdges(V v) {
        return g.getEdges(v);
    }

    @Override
    public String toString() {
        return GraphToString.toString(this);
    }
}
