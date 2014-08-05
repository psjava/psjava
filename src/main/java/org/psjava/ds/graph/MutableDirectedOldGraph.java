package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.util.AssertStatus;

public class MutableDirectedOldGraph<V> implements OldGraph<V, DirectedEdge<V>> {

	public static <V> MutableDirectedOldGraph<V> create() {
		return new MutableDirectedOldGraph<V>();
	}

	private MutableOldGraph<V, DirectedEdge<V>> graph = MutableOldGraph.create();

	public void insertVertex(V v) {
		graph.insertVertex(v);
	}

	public void addEdge(V from, V to) {
		assertVertexExist(from);
		assertVertexExist(to);
		graph.addEdge(SimpleDirectedEdge.create(from, to));
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
