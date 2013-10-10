package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.set.MutableSet;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.util.AssertStatus;

public class MutableUndirectedWeightedGraph<V, W> implements Graph<V, UndirectedWeightedEdge<V, W>> {

	public static <V, W> MutableUndirectedWeightedGraph<V, W> create() {
		return new MutableUndirectedWeightedGraph<V, W>();
	}

	private MutableSet<V> vertices = GoodMutableSetFactory.getInstance().create();
	private DynamicArray<UndirectedWeightedEdge<V, W>> edges = DynamicArray.create();

	public void insertVertex(V v) {
		vertices.insert(v);
	}

	public void addEdge(V v1, V v2, W weight) {
		assertVertexExist(v1);
		assertVertexExist(v2);
		edges.addToLast(UndirectedWeightedEdgeFactory.create(v1, v2, weight));
	}

	private void assertVertexExist(V v) {
		AssertStatus.assertTrue(vertices.contains(v), "vertex is not in graph");
	}

	@Override
	public Collection<V> getVertices() {
		return vertices;
	}

	@Override
	public Iterable<UndirectedWeightedEdge<V, W>> getEdges() {
		return edges;
	}

	@Override
	public String toString() {
		return GraphToString.toString(this);
	}
}
