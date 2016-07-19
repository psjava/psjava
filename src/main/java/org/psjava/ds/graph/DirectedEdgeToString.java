package org.psjava.ds.graph;

public class DirectedEdgeToString {

    public static <V> String toString(DirectedEdge<V> e) {
        return e.from() + "->" + e.to();
    }

    private DirectedEdgeToString() {
    }

}
