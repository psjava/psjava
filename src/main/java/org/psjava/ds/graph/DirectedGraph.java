package org.psjava.ds.graph;

public interface DirectedGraph<E extends DirectedEdge> extends DirectedAdjacencyListableGraph<E> {

	Iterable<E> getEdges();

	Iterable<E> getOutEdges(Object from, Object to);

	boolean hasEdge(Object from, Object to);
}
