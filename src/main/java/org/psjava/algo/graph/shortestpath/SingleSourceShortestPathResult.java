package org.psjava.algo.graph.shortestpath;

public interface SingleSourceShortestPathResult<V, W, E> {

    Iterable<E> getPath(V to);

    W getDistance(V to);

    boolean isReachable(V to);
}
