package org.psjava.algo.graph.matching;

public interface MaximumBipartiteMatchingResult<V> {
	int getMaxMatchCount();

	boolean hasMatch(V v);

	V getMatchedVertex(V v);
}
