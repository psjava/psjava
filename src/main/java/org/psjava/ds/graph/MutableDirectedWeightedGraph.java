package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.set.MutableSet;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.javautil.AssertStatus;

public class MutableDirectedWeightedGraph<W> implements DirectedWeightedGraph<W> {

	public static <W> MutableDirectedWeightedGraph<W> create() {
		return new MutableDirectedWeightedGraph<W>();
	}

	private MutableSet<Object> vertices = GoodMutableSetFactory.getInstance().create();
	private DynamicArray<DirectedWeightedEdge<W>> edges = DynamicArray.create();

	public void insertVertex(Object v) {
		vertices.insert(v);
	}

	public void addEdge(Object from, Object to, W weight) {
		assertVertexExist(from);
		assertVertexExist(to);
		edges.addToLast(DirectedWeightedEdgeFactory.create(from, to, weight));
	}

	private void assertVertexExist(Object v) {
		AssertStatus.assertTrue(vertices.contains(v), "vertex is not in graph");
	}

	@Override
	public Collection<Object> getVertices() {
		return vertices;
	}

	@Override
	public Iterable<DirectedWeightedEdge<W>> getEdges() {
		return edges;
	}

	@Override
	public String toString() {
		String r = "";
		for (DirectedWeightedEdge<W> e : getEdges()) {
			if (r.length() != 0)
				r += ", ";
			r += e.toString();
		}
		return "Graph: " + r;
	}
}
