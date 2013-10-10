package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.set.MutableSet;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.util.AssertStatus;
import org.psjava.util.IterableToString;

public class MutableBipartiteGraph<V> implements BipartiteGraph<V> {

	public static <V> MutableBipartiteGraph<V> create() {
		return new MutableBipartiteGraph<V>();
	}

	private MutableSet<V> left = GoodMutableSetFactory.getInstance().create();
	private MutableSet<V> right = GoodMutableSetFactory.getInstance().create();
	private DynamicArray<BipartiteGraphEdge<V>> edges = DynamicArray.create();

	public void insertLeftVertex(V v) {
		AssertStatus.assertTrue(!right.contains(v));
		left.insert(v);
	}

	public void insertRightVertex(V v) {
		AssertStatus.assertTrue(!left.contains(v));
		right.insert(v);
	}

	public void addEdge(final V leftv, final V rightv) {
		assertVertexExist(leftv, left);
		assertVertexExist(rightv, right);
		edges.addToLast(BipartiteGraphEdgeFactory.create(leftv, rightv));
	}

	private void assertVertexExist(V v, MutableSet<V> set) {
		AssertStatus.assertTrue(set.contains(v), "vertex is not in graph");
	}

	@Override
	public Collection<V> getLeftVertices() {
		return left;
	}

	@Override
	public Collection<V> getRightVertices() {
		return right;
	}

	@Override
	public Iterable<BipartiteGraphEdge<V>> getEdges() {
		return edges;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ":" + IterableToString.toString(getEdges());
	}
}
