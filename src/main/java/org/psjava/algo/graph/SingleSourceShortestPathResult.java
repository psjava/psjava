package org.psjava.algo.graph;

public interface SingleSourceShortestPathResult<W, E> {
	Iterable<E> getEdgePath(Object to); 
	W getDistance(Object to); // TODO throws if not reachable
	boolean isReachable(Object to); // TODO assert status
}
