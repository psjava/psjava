package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;

public class AdjacencyListableDirectedWeightedGraphFactory {
	public static <V, W> AdjacencyListableDirectedWeightedGraph<V, W> create(final DirectedWeightedGraph<V, W> g) {
		final MutableMap<Object, DynamicArray<DirectedWeightedEdge<V, W>>> index = GoodMutableMapFactory.getInstance().create();
		for (Object v : g.getVertices())
			index.put(v, new DynamicArray<DirectedWeightedEdge<V, W>>());
		for (DirectedWeightedEdge<V, W> e : g.getEdges())
			index.get(e.from()).addToLast(e);
		return new AdjacencyListableDirectedWeightedGraph<V, W>() {
			@Override
			public Collection<V> getVertices() {
				return g.getVertices();
			}

			@Override
			public Iterable<DirectedWeightedEdge<V, W>> getEdges(Object from) {
				return index.get(from);
			}
		};
	}
}
