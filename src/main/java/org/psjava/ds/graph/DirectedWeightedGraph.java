package org.psjava.ds.graph;

import org.psjava.ds.Collection;

public interface DirectedWeightedGraph<W> {

	Collection<Object> getVertices();

	Iterable<DirectedWeightedEdge<W>> getEdges();

}