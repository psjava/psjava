package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.Collection;

public interface NegativeCycleFinderResult<E> {
	boolean hasCycle();

	Collection<E> getPath();
}