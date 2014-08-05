package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.util.AssertStatus;

public class MutableUndirectedWeightedGraph<V, W> implements Graph<V, UndirectedWeightedEdge<V, W>> {

	public static <V, W> MutableUndirectedWeightedGraph<V, W> create() {
		return new MutableUndirectedWeightedGraph<V, W>();
	}

	private MutableGraph<V, UndirectedWeightedEdge<V, W>> g = MutableGraph.create();

	public void insertVertex(V v) {
		g.insertVertex(v);
	}

	public void addEdge(V v1, V v2, W weight) {
		assertVertexExist(v1);
		assertVertexExist(v2);
		UndirectedWeightedEdge<V, W> edge = SimpleUndirectedWeightedEdge.create(v1, v2, weight);
		g.addEdge(v1, edge);
		g.addEdge(v2, edge);
	}

	private void assertVertexExist(V v) {
		AssertStatus.assertTrue(g.getVertices().contains(v), "vertex is not in graph");
	}

	@Override
	public Collection<V> getVertices() {
		return g.getVertices();
	}

	@Override
	public Iterable<UndirectedWeightedEdge<V, W>> getEdges(V v) {
		return g.getEdges(v);
	}

	@Override
	public String toString() {
		return GraphToString.toString(this);
	}
}
