package org.psjava.ds.graph;


public class OppositeInUndirectedEdge {

    public static <V, E extends UndirectedEdge<V>> V get(E e, V v) {
        return v.equals(e.v1()) ? e.v2() : e.v1();
    }

    private OppositeInUndirectedEdge() {
    }

}
