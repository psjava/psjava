package org.psjava.ds.graph;

import org.psjava.ds.PSCollection;

@Deprecated
public interface BipartiteGraph<V> {

    PSCollection<V> getLeftVertices();

    PSCollection<V> getRightVertices();

    Iterable<BipartiteGraphEdge<V>> getEdges();

}