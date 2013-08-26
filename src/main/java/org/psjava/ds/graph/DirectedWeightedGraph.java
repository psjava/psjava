package org.psjava.ds.graph;

public interface DirectedWeightedGraph<W> {

	Iterable<Object> getVertices();

	Iterable<DirectedWeightedEdge<W>> getEdges();

}