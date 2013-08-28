package org.psjava.ds.graph;

import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;

public class DirectedWeightedAdjacencyList<W> {

	public static <W> DirectedWeightedAdjacencyList<W> create(DirectedWeightedGraph<W> g) {
		return new DirectedWeightedAdjacencyList<W>(g);
	}

	private final MutableMap<Object, DynamicArray<DirectedWeightedEdge<W>>> index = GoodMutableMapFactory.getInstance().create();

	private DirectedWeightedAdjacencyList(DirectedWeightedGraph<W> g) {
		for (Object v : g.getVertices())
			index.put(v, new DynamicArray<DirectedWeightedEdge<W>>());
		for (DirectedWeightedEdge<W> e : g.getEdges())
			index.get(e.from()).addToLast(e);
	}

	public Iterable<DirectedWeightedEdge<W>> getEdges(Object from) {
		return index.get(from);
	}
}