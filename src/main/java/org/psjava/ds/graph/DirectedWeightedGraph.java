package org.psjava.ds.graph;

import org.psjava.ds.Collection;

public interface DirectedWeightedGraph<V, W> {

	Collection<V> getVertices();

	Iterable<DirectedWeightedEdge<V, W>> getEdges();

}