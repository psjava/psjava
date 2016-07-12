package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.math.Function;

public class SimpleDirectedWeightedGraph<V, W> implements Graph<V, SimpleDirectedWeightedEdgeV2<V, W>> {

    public static <V, W> SimpleDirectedWeightedGraph<V, W> create() {
        return new SimpleDirectedWeightedGraph<V, W>();
    }

    private SimpleDirectedGraph<V, SimpleDirectedWeightedEdgeV2<V, W>> g = SimpleDirectedGraph.create();

    public void insertVertex(V v) {
        g.insertVertex(v);
    }

    public void addEdge(V from, V to, W weight) {
        g.addEdge(new SimpleDirectedWeightedEdgeV2<V, W>(from, to, weight));
    }

    @Override
    public Collection<V> getVertices() {
        return g.getVertices();
    }

    @Override
    public Iterable<SimpleDirectedWeightedEdgeV2<V, W>> getEdges(V v) {
        return g.getEdges(v);
    }

    @Override
    public String toString() {
        return g.toString();
    }

    public Function<SimpleDirectedWeightedEdgeV2<V, W>, W> getWeightFunction() {
        return SimpleDirectedWeightedEdgeV2.createWeightFunction();
    }

}
