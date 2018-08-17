package org.psjava;

public class UnweightedGraph<V> {

    public GraphV2<V, V> graph = new GraphV2<>();

    public void addVertex(V v) {
        graph.addVertex(v);
    }

    public void addEdge(V from, V to) {
        graph.addEdge(from, to);
    }

}
