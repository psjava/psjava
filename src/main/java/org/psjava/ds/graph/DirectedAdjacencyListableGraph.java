package org.psjava.ds.graph;

public interface DirectedAdjacencyListableGraph<E extends DirectedEdge> {

	Iterable<Object> getVertices();

	Iterable<E> getOutEdges(Object from);

	int size();

}