package org.psjava.ds.graph;

import org.psjava.ds.Collection;

public interface AdjacencyListableDirectedWeightedGraph<W> {
	Collection<Object> getVertices();

	Iterable<DirectedWeightedEdge<W>> getEdges(Object from);
}
