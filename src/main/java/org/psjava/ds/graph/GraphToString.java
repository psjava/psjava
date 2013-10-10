package org.psjava.ds.graph;

import org.psjava.util.IterableToString;

public class GraphToString {

	public static <V, E> String toString(Graph<V, E> g) {
		String r = "";
		for (E e : g.getEdges()) {
			if (r.length() != 0)
				r += ", ";
			r += e.toString();
		}
		return "Graph({" + IterableToString.toString(g.getVertices()) + "},{" + IterableToString.toString(g.getEdges()) + "})";
	}

}
