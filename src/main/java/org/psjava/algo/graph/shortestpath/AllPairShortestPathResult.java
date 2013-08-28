package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;

public interface AllPairShortestPathResult<W> {
	Iterable<DirectedWeightedEdge<W>> getPath(Object from, Object to);

	W getDistance(Object from, Object to);

	boolean isReachable(Object from, Object to);
}
