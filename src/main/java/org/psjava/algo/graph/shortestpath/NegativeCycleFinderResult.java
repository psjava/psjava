package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.Collection;
import org.psjava.ds.graph.DirectedWeightedEdge;

public interface NegativeCycleFinderResult<V, W> {
	boolean hasCycle();

	Collection<DirectedWeightedEdge<V, W>> getPath();
}