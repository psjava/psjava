package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.util.AssertStatus;

public class MutableUndirectedGraph<V> implements Graph<V, UndirectedEdge<V>> {

	public static <V> MutableUndirectedGraph<V> create() {
		return new MutableUndirectedGraph<V>();
	}

	private final MutableGraph<V, UndirectedEdge<V>> g = MutableGraph.create();

	public void insertVertex(V v) {
		g.insertVertex(v);
	}

	public void addEdge(V v1, V v2) {
		assertVertexExist(v1);
		assertVertexExist(v2);
		UndirectedEdge<V> edge = SimpleUndirectedEdge.create(v1, v2);
		g.addEdge(v1, edge);
		g.addEdge(v2, edge);
	}

	@Override
	public Collection<V> getVertices() {
		return g.getVertices();
	}

	private void assertVertexExist(V v) {
		AssertStatus.assertTrue(g.getVertices().contains(v), "vertex is not in graph");
	}

	@Override
	public Iterable<UndirectedEdge<V>> getEdges(V v) {
		return g.getEdges(v);
	}

	@Override
	public String toString() {
		return GraphToString.toString(this);
	}
}
