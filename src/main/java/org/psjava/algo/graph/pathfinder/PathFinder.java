package org.psjava.algo.graph.pathfinder;

import org.psjava.ds.Collection;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;

public interface PathFinder {
	<V, E extends DirectedEdge<V>> Collection<E> find(Graph<V, E> g, V start, V end, Collection<E> def);
}