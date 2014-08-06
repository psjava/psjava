package org.psjava.algo.graph;

import org.psjava.algo.graph.matching.MaximumBipartiteMatching;
import org.psjava.ds.graph.BipartiteGraph;

public class KonigTheorem {

	public static MinimumVertexCoverAlgorithmInBipartiteGraph getInstance(final MaximumBipartiteMatching mbm) {
		return new MinimumVertexCoverAlgorithmInBipartiteGraph() {
			@Override
			public <V, E> int calcMinimumVertexCover(BipartiteGraph<V> bg) {
				return mbm.calc(bg).getMaxMatchCount();
			}
		};
	}

	private KonigTheorem() {}

}
