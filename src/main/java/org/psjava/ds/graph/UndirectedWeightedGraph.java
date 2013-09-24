package org.psjava.ds.graph;

import org.psjava.ds.Collection;

public interface UndirectedWeightedGraph<V, W> {

	Collection<V> getVertices();

	Iterable<UndirectedWeightedEdge<V, W>> getEdges();

}