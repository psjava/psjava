package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.set.MutableSet;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.util.AssertStatus;

public class MutableDirectedWeightedOldGraph<V, W> implements OldGraph<V, DirectedWeightedEdge<V, W>> {

	// TODO use MutableGraph

	public static <V, W> MutableDirectedWeightedOldGraph<V, W> create() {
		return new MutableDirectedWeightedOldGraph<V, W>();
	}

	private MutableSet<V> vertices = GoodMutableSetFactory.getInstance().create();
	private DynamicArray<DirectedWeightedEdge<V, W>> edges = DynamicArray.create();

	public void insertVertex(V v) {
		vertices.addIfAbsent(v);
	}

	public void addEdge(V from, V to, W weight) {
		assertVertexExist(from);
		assertVertexExist(to);
		edges.addToLast(SimpleDirectedWeightedEdge.create(from, to, weight));
	}

	private void assertVertexExist(V v) {
		AssertStatus.assertTrue(vertices.contains(v), "vertex is not in graph");
	}

	@Override
	public Collection<V> getVertices() {
		return vertices;
	}

	@Override
	public Iterable<DirectedWeightedEdge<V, W>> getEdges() {
		return edges;
	}

	@Override
	public String toString() {
		return GraphToString.toString(this);
	}

}
