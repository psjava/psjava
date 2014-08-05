package org.psjava.ds.graph;

import org.psjava.ds.Collection;

// TODO rename MutableDirectedUnweightedGraph
public class MutableDirectedGraph<V> implements Graph<V, DirectedEdge<V>> {

	public static <V> MutableDirectedGraph<V> create() {
		return new MutableDirectedGraph<V>();
	}

	private MutableDirectedGraphV2<V, DirectedEdge<V>> graph = MutableDirectedGraphV2.create();

	public void insertVertex(V v) {
		graph.insertVertex(v);
	}

	public void addEdge(V from, V to) {
		graph.addEdge(SimpleDirectedEdge.create(from, to));
	}

	@Override
	public Collection<V> getVertices() {
		return graph.getVertices();
	}

	@Override
	public Iterable<DirectedEdge<V>> getEdges(V v) {
		return graph.getEdges(v);
	}

	@Override
	public String toString() {
		return graph.toString();
	}

}
