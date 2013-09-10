package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.set.MutableSet;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.javautil.AssertStatus;
import org.psjava.javautil.IterableToString;

public class MutableUndirectedGraph implements UndirectedGraph {

	public static UndirectedGraph create() {
		return new MutableUndirectedGraph();
	}

	private MutableSet<Object> vertices = GoodMutableSetFactory.getInstance().create();
	private DynamicArray<UndirectedEdge> edges = DynamicArray.create();

	public void insertVertex(Object v) {
		vertices.insert(v);
	}

	public void addEdge(Object v1, Object v2) {
		assertVertexExist(v1);
		assertVertexExist(v2);
		edges.addToLast(UndirectedEdgeFactory.create(v1, v2));
	}

	private void assertVertexExist(Object v) {
		AssertStatus.assertTrue(vertices.contains(v), "vertex is not in graph");
	}

	@Override
	public Collection<Object> getVertices() {
		return vertices;
	}

	@Override
	public Iterable<UndirectedEdge> getEdges() {
		return edges;
	}

	@Override
	public String toString() {
		return "Graph: " + IterableToString.toString(getEdges());
	}
}
