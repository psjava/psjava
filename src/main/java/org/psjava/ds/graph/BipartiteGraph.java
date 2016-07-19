package org.psjava.ds.graph;

import org.psjava.ds.Collection;

public interface BipartiteGraph<V> {

    Collection<V> getLeftVertices();

    Collection<V> getRightVertices();

    Iterable<BipartiteGraphEdge<V>> getEdges();

}