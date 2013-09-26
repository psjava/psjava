package org.psjava.ds.graph;

import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;

public class DirectedWeightedAdjacencyList<V, E extends DirectedEdge<V>> {
	// TODO rename EdgesByTail

	public static <V, E extends DirectedEdge<V>> DirectedWeightedAdjacencyList<V, E> create(Graph<V, E> g) {
		return new DirectedWeightedAdjacencyList<V, E>(g);
	}

	private final MutableMap<V, DynamicArray<E>> index = GoodMutableMapFactory.getInstance().create();

	private DirectedWeightedAdjacencyList(Graph<V, E> g) {
		for (V v : g.getVertices())
			index.put(v, new DynamicArray<E>());
		for (E e : g.getEdges())
			index.get(e.from()).addToLast(e);
	}

	public Iterable<E> getEdges(V from) {
		return index.get(from);
	}
}