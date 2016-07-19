package org.psjava.algo.graph;

public interface DistanceCalculatorInRootedTreeResult<V, W> {
    void modifyDistance(V v1, V v2, W w);

    W getDistance(V v1, V v2);
}
