package org.psjava.ds.graph;

import org.psjava.ds.Collection;

public interface UndirectedWeightedGraph<W> {

	Collection<Object> getVertices();

	Iterable<UndirectedWeightedEdge<W>> getEdges();

}