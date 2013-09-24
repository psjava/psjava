package org.psjava.ds.graph;

import org.psjava.ds.Collection;

public interface AdjacencyListableDirectedWeightedGraph<V, W> {
	Collection<V> getVertices();

	Iterable<DirectedWeightedEdge<V, W>> getEdges(Object from);
}
