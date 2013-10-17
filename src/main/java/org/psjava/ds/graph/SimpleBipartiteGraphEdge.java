package org.psjava.ds.graph;

public class SimpleBipartiteGraphEdge {

	public static <V> BipartiteGraphEdge<V> create(final V leftv, final V rightv) {
		return new BipartiteGraphEdge<V>() {
			@Override
			public V right() {
				return rightv;
			}

			@Override
			public V left() {
				return leftv;
			}

			@Override
			public String toString() {
				return leftv + "->" + rightv;
			}
		};
	}

}
