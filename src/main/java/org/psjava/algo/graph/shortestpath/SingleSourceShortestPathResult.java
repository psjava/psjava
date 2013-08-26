package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;

public interface SingleSourceShortestPathResult<W> {

	Iterable<DirectedWeightedEdge<W>> getPath(Object to);

	W getDistance(Object to);

	boolean isReachable(Object to);
}
