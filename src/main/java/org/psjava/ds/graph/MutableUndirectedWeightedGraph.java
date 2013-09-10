package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.set.MutableSet;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.javautil.AssertStatus;

public class MutableUndirectedWeightedGraph<W> implements UndirectedWeightedGraph<W> {

	public static <W> MutableUndirectedWeightedGraph<W> create() {
		return new MutableUndirectedWeightedGraph<W>();
	}

	private MutableSet<Object> vertices = GoodMutableSetFactory.getInstance().create();
	private DynamicArray<UndirectedWeightedEdge<W>> edges = DynamicArray.create();

	public void insertVertex(Object v) {
		vertices.insert(v);
	}

	public void addEdge(Object v1, Object v2, W weight) {
		assertVertexExist(v1);
		assertVertexExist(v2);
		edges.addToLast(UndirectedWeightedEdgeFactory.create(v1, v2, weight));
	}

	private void assertVertexExist(Object v) {
		AssertStatus.assertTrue(vertices.contains(v), "vertex is not in graph");
	}

	@Override
	public Collection<Object> getVertices() {
		return vertices;
	}

	@Override
	public Iterable<UndirectedWeightedEdge<W>> getEdges() {
		return edges;
	}

	@Override
	public String toString() {
		String r = "";
		for (UndirectedWeightedEdge<W> e : getEdges()) {
			if (r.length() != 0)
				r += ", ";
			r += e.toString();
		}
		return "Graph: " + r;
	}
}
