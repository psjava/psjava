package org.psjava.ds.graph;

import java.util.Collection;

public class MutableCapacityGraph<V, F> implements Graph<V, CapacityEdge<V, F>> {

    public static <V, F> MutableCapacityGraph<V, F> create() {
        return new MutableCapacityGraph<V, F>();
    }

    private final SimpleDirectedGraph<V, CapacityEdge<V, F>> g = SimpleDirectedGraph.create();

    @Override
    public Iterable<CapacityEdge<V, F>> getEdges(V v) {
        return g.getEdges(v);
    }

    @Override
    public Collection<V> getVertices() {
        return g.getVertices();
    }

    public void insertVertex(V v) {
        g.insertVertex(v);
    }

    public void addEdge(V from, V to, F capacity) {
        g.addEdge(SimpleCapacityEdge.create(from, to, capacity));
    }

    @Override
    public String toString() {
        return GraphToString.toString(this);
    }
}
