package org.psjava.ds.graph;

import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;

public class AdjacencyListableDirectedWeightedGraphFactory {
	public static <W> AdjacencyListableDirectedWeightedGraph<W> create(final DirectedWeightedGraph<W> g) {
		final MutableMap<Object, DynamicArray<DirectedWeightedEdge<W>>> index = GoodMutableMapFactory.getInstance().create();
		for (Object v : g.getVertices())
			index.put(v, new DynamicArray<DirectedWeightedEdge<W>>());
		for (DirectedWeightedEdge<W> e : g.getEdges())
			index.get(e.from()).addToLast(e);
		return new AdjacencyListableDirectedWeightedGraph<W>() {
			@Override
			public Iterable<Object> getVertices() {
				return g.getVertices();
			}

			@Override
			public Iterable<DirectedWeightedEdge<W>> getEdges(Object from) {
				return index.get(from);
			}
		};
	}
}
