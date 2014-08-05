package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.util.AssertStatus;

public class MutableUndirectedOldGraph<V> implements OldGraph<V, UndirectedEdge<V>> {

	public static <V> MutableUndirectedOldGraph<V> create() {
		return new MutableUndirectedOldGraph<V>();
	}

	private final MutableOldGraph<V, UndirectedEdge<V>> g = MutableOldGraph.create();

	public void insertVertex(V v) {
		g.insertVertex(v);
	}

	public void addEdge(V v1, V v2) {
		assertVertexExist(v1);
		assertVertexExist(v2);
		g.addEdge(SimpleUndirectedEdge.create(v1, v2));
	}

	@Override
	public Collection<V> getVertices() {
		return g.getVertices();
	}

	private void assertVertexExist(V v) {
		AssertStatus.assertTrue(g.getVertices().contains(v), "vertex is not in graph");
	}

	@Override
	public Iterable<UndirectedEdge<V>> getEdges() {
		return g.getEdges();
	}

	@Override
	public String toString() {
		return GraphToString.toString(this);
	}
}
