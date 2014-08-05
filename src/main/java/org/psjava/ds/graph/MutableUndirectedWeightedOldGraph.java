package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.util.AssertStatus;

public class MutableUndirectedWeightedOldGraph<V, W> implements OldGraph<V, UndirectedWeightedEdge<V, W>> {

	public static <V, W> MutableUndirectedWeightedOldGraph<V, W> create() {
		return new MutableUndirectedWeightedOldGraph<V, W>();
	}

	private MutableOldGraph<V, UndirectedWeightedEdge<V, W>> g = MutableOldGraph.create();

	public void insertVertex(V v) {
		g.insertVertex(v);
	}

	public void addEdge(V v1, V v2, W weight) {
		assertVertexExist(v1);
		assertVertexExist(v2);
		g.addEdge(SimpleUndirectedWeightedEdge.create(v1, v2, weight));
	}

	private void assertVertexExist(V v) {
		AssertStatus.assertTrue(g.getVertices().contains(v), "vertex is not in graph");
	}

	@Override
	public Collection<V> getVertices() {
		return g.getVertices();
	}

	@Override
	public Iterable<UndirectedWeightedEdge<V, W>> getEdges() {
		return g.getEdges();
	}

	@Override
	public String toString() {
		return GraphToString.toString(this);
	}
}
