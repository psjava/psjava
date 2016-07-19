package org.psjava.algo.graph.shortestpath;

public interface AllPairShortestPathResult<V, W, E> {
    Iterable<E> getPath(V from, V to);

    W getDistance(V from, V to);

    boolean isReachable(V from, V to);
}
