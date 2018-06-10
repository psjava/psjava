package org.psjava.algo.graph.pathfinder;

import org.psjava.ds.PSCollection;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;

public interface PathFinder {
    <V, E extends DirectedEdge<V>> PSCollection<E> find(Graph<V, E> g, V start, V end, PSCollection<E> def);
}