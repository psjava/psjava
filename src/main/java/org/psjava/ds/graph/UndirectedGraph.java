package org.psjava.ds.graph;

import org.psjava.ds.Collection;

public interface UndirectedGraph {

	Collection<Object> getVertices();

	Iterable<UndirectedEdge> getEdges();

}