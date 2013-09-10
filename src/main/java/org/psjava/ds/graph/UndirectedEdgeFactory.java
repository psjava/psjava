package org.psjava.ds.graph;

public class UndirectedEdgeFactory {

	public static UndirectedEdge create(final Object v1, final Object v2) {
		return new UndirectedEdge() {

			@Override
			public Object v1() {
				return v1;
			}

			@Override
			public Object v2() {
				return v2;
			}

			@Override
			public String toString() {
				return v1 + "-" + v2;
			}
		};
	}

}