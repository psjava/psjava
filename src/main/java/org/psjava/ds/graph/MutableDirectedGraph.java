package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.javautil.AssertStatus;

public class MutableDirectedGraph<V> implements Graph<V, DirectedEdge<V>> {

	public static <V> MutableDirectedGraph<V> create() {
		return new MutableDirectedGraph<V>();
	}

	private MutableGraph<V, DirectedEdge<V>> graph = MutableGraph.create();

	public void insertVertex(V v) {
		graph.insertVertex(v);
	}

	public void addEdge(V from, V to) {
		assertVertexExist(from);
		assertVertexExist(to);
		graph.addEdge(DirectedEdgeFactory.create(from, to));
	}

	private void assertVertexExist(V v) {
		AssertStatus.assertTrue(graph.getVertices().contains(v), "vertex is not in graph");
	}

	@Override
	public Collection<V> getVertices() {
		return graph.getVertices();
	}

	@Override
	public Iterable<DirectedEdge<V>> getEdges() {
		return graph.getEdges();
	}

	@Override
	public String toString() {
		return GraphToString.toString(this);
	}

}
