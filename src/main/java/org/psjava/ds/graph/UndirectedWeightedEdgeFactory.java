package org.psjava.ds.graph;

public class UndirectedWeightedEdgeFactory {

	public static <W> UndirectedWeightedEdge<W> create(final Object v1, final Object v2, final W weight) {
		return new UndirectedWeightedEdge<W>() {

			@Override
			public Object v1() {
				return v1;
			}

			@Override
			public Object v2() {
				return v2;
			}

			@Override
			public W weight() {
				return weight;
			}

			@Override
			public String toString() {
				return v1 + "-" + v2 + "(" + weight + ")";
			}
		};
	}

}