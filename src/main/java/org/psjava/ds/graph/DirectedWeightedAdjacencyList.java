package org.psjava.ds.graph;

import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;

public class DirectedWeightedAdjacencyList<V, W> {

	public static <V, W> DirectedWeightedAdjacencyList<V, W> create(DirectedWeightedGraph<V, W> g) {
		return new DirectedWeightedAdjacencyList<V, W>(g);
	}

	private final MutableMap<V, DynamicArray<DirectedWeightedEdge<V, W>>> index = GoodMutableMapFactory.getInstance().create();

	private DirectedWeightedAdjacencyList(DirectedWeightedGraph<V, W> g) {
		for (V v : g.getVertices())
			index.put(v, new DynamicArray<DirectedWeightedEdge<V, W>>());
		for (DirectedWeightedEdge<V, W> e : g.getEdges())
			index.get(e.from()).addToLast(e);
	}

	public Iterable<DirectedWeightedEdge<V, W>> getEdges(V from) {
		return index.get(from);
	}
}