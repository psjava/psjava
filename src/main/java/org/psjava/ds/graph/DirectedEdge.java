package org.psjava.ds.graph;

public interface DirectedEdge<V> { // TODO introduce Edge interface, and assert existence in MutableGraph.addEdge
    V from();

    V to();
}
