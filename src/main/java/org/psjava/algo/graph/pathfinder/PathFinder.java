package org.psjava.algo.graph.pathfinder;

import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;

import java.util.Collection;

public interface PathFinder {
    <V, E extends DirectedEdge<V>> Collection<E> find(Graph<V, E> g, V start, V end, Collection<E> def);
}