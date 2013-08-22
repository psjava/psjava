package org.psjava.ds.graph;

public class DirectedEdgeFactory {

	public static DirectedEdge create(final Object from, final Object to) {
		return new DirectedEdge() {
			@Override
			public Object to() {
				return to;
			}
			@Override
			public Object from() {
				return from;
			}
		};
	}

}
