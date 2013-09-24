package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;

public interface AllPairShortestPathResult<V, W> {
	Iterable<DirectedWeightedEdge<V, W>> getPath(V from, V to);

	W getDistance(V from, V to);

	boolean isReachable(V from, V to);
}
