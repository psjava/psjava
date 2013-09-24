package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.set.MutableSet;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.javautil.AssertStatus;

public class MutableDirectedWeightedGraph<V, W> implements DirectedWeightedGraph<V, W> {

	public static <V, W> MutableDirectedWeightedGraph<V, W> create() {
		return new MutableDirectedWeightedGraph<V, W>();
	}

	private MutableSet<V> vertices = GoodMutableSetFactory.getInstance().create();
	private DynamicArray<DirectedWeightedEdge<V, W>> edges = DynamicArray.create();

	public void insertVertex(V v) {
		vertices.insert(v);
	}

	public void addEdge(V from, V to, W weight) {
		assertVertexExist(from);
		assertVertexExist(to);
		edges.addToLast(DirectedWeightedEdgeFactory.create(from, to, weight));
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
		String r = "";
		for (DirectedWeightedEdge<V, W> e : getEdges()) {
			if (r.length() != 0)
				r += ", ";
			r += e.toString();
		}
		return "Graph: " + r;
	}
}
