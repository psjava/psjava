package org.psjava.algo.graph.pathfinder;

import org.psjava.ds.Collection;
import org.psjava.ds.graph.AdjacencyList;
import org.psjava.ds.graph.DirectedEdge;

public interface PathFinder {
	<V, E extends DirectedEdge<V>> Collection<E> find(AdjacencyList<V, E> g, V start, V end, Collection<E> def);
}