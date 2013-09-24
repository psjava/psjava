package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;

public interface SingleSourceShortestPathResult<V, W> {

	Iterable<DirectedWeightedEdge<V, W>> getPath(V to);

	W getDistance(V to);

	boolean isReachable(V to);
}
