package org.psjava.ds.graph;

import org.psjava.util.IterableToString;

public class GraphToString {

    public static <V, E> String toString(Graph<V, E> g) {
        return "Graph({" + IterableToString.toString(g.getVertices()) + "},{" + IterableToString.toString(AllEdgeInGraph.wrap(g)) + "})";
    }

    private GraphToString() {
    }

}
