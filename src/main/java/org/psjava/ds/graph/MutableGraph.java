package org.psjava.ds.graph;

import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.set.MutableSet;
import org.psjava.ds.set.Set;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.goods.GoodMutableSetFactory;

public class MutableGraph<V, E> implements Graph<V, E> {

	public static <V, E> MutableGraph<V, E> create() {
		return new MutableGraph<V, E>();
	}

	private MutableSet<V> vertices = GoodMutableSetFactory.getInstance().create();
	private MutableMap<V, DynamicArray<E>> edgeMap = GoodMutableMapFactory.getInstance().create();

	public void insertVertex(V v) {
		if(!vertices.contains(v)) {
			vertices.add(v);
			edgeMap.add(v, new DynamicArray<E>());
		}
	}

	public void addEdge(V from, E edge) {
		edgeMap.get(from).addToLast(edge);
	}

	@Override
	public Set<V> getVertices() {
		return vertices;
	}

	@Override
	public Iterable<E> getEdges(V v) {
		return edgeMap.get(v);
	}

	@Override
	public String toString() {
		return GraphToString.toString(this);
	}

}
