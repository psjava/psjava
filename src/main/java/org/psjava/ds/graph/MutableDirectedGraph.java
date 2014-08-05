package org.psjava.ds.graph;

import org.psjava.ds.Collection;

public class MutableDirectedGraph<V, E extends DirectedEdge<V>> implements Graph<V, E> {

	public static <V, E extends DirectedEdge<V>> MutableDirectedGraph<V,E> create() {
		return new MutableDirectedGraph<V,E>();
	}

	private MutableGraph<V, E> graph = MutableGraph.create();

	public void insertVertex(V v) {
		graph.insertVertex(v);
	}

	public void addEdge(E edge) {
		graph.addEdge(edge.from(), edge);
	}

	@Override
	public Collection<V> getVertices() {
		return graph.getVertices();
	}

	@Override
	public Iterable<E> getEdges(V v) {
		return graph.getEdges(v);
	}

	@Override
	public String toString() {
		return graph.toString();
	}

}
