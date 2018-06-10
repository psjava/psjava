package org.psjava.ds;

import org.psjava.ds.graph.DirectedEdge;

import java.util.function.Function;

public class SimpleDirectedWeightedEdge<V, W> implements DirectedEdge<V> {

    public static <V, W> Function<SimpleDirectedWeightedEdge<V, W>, W> createWeightFunction() {
        return new Function<SimpleDirectedWeightedEdge<V, W>, W>() {
            @Override
            public W apply(SimpleDirectedWeightedEdge<V, W> a) {
                return a.weight;
            }
        };
    }

    private final V from;
    private final V to;
    private final W weight;

    public SimpleDirectedWeightedEdge(V from, V to, W weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public V from() {
        return from;
    }

    @Override
    public V to() {
        return to;
    }

    @Override
    public String toString() {
        return from + "->" + to + "(" + weight + ")";
    }
}