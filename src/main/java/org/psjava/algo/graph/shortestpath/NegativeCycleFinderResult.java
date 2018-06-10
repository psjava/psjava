package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.PSCollection;

// TODO introduce Optional or as other name.
public interface NegativeCycleFinderResult<E> {
    boolean hasCycle();

    PSCollection<E> getPath();
}