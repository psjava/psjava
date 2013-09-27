package org.psjava.ds.graph;

import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;

public class IndexedEdgesByFrom<V, E extends DirectedEdge<V>> {

	public static <V, E extends DirectedEdge<V>> IndexedEdgesByFrom<V, E> create(Graph<V, E> g) {
		return new IndexedEdgesByFrom<V, E>(g);
	}

	private final MutableMap<V, DynamicArray<E>> index = GoodMutableMapFactory.getInstance().create();

	private IndexedEdgesByFrom(Graph<V, E> g) {
		for (V v : g.getVertices())
			index.put(v, new DynamicArray<E>());
		for (E e : g.getEdges())
			index.get(e.from()).addToLast(e);
	}

	public Iterable<E> getEdges(V from) {
		return index.get(from);
	}
}