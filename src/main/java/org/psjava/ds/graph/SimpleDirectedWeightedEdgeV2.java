package org.psjava.ds.graph;

import org.psjava.ds.math.Function;

public class SimpleDirectedWeightedEdgeV2<V, W> implements DirectedEdge<V> {

    public static <V, W> Function<SimpleDirectedWeightedEdgeV2<V, W>, W> createWeightFunction() {
        return new Function<SimpleDirectedWeightedEdgeV2<V, W>, W>() {
            @Override
            public W get(SimpleDirectedWeightedEdgeV2<V, W> a) {
                return a.weight;
            }
        };
    }

    private final V from;
    private final V to;
    private final W weight;

    public SimpleDirectedWeightedEdgeV2(V from, V to, W weight) {
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