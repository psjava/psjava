package org.psjava.ds.graph;


public interface AdjacencyListableDirectedWeightedGraph<W> {
	Iterable<Object> getVertices();

	Iterable<DirectedWeightedEdge<W>> getEdges(Object from);
}
