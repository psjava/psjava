package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.Collection;

// TODO introduce Optional or as other name.
public interface NegativeCycleFinderResult<E> {
	boolean hasCycle();

	Collection<E> getPath();
}