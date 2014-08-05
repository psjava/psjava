package org.psjava.ds.graph;

import org.psjava.ds.Collection;

public class MutableDirectedWeightedGraph<V, W> implements Graph<V, DirectedWeightedEdge<V, W>> {

	public static <V, W> MutableDirectedWeightedGraph<V, W> create() {
		return new MutableDirectedWeightedGraph<V, W>();
	}

	private MutableDirectedGraph<V, DirectedWeightedEdge<V, W>> g = MutableDirectedGraph.create();

	public void insertVertex(V v) {
		g.insertVertex(v);
	}

	public void addEdge(V from, V to, W weight) {
		g.addEdge(SimpleDirectedWeightedEdge.create(from, to, weight));
	}

	@Override
	public Collection<V> getVertices() {
		return g.getVertices();
	}

	@Override
	public Iterable<DirectedWeightedEdge<V, W>> getEdges(V v) {
		return g.getEdges(v);
	}

	@Override
	public String toString() {
		return g.toString();
	}

}
