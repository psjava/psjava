package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.util.IterableToString;

public class AdjacencyListFromGraph {

	public static <V, E extends DirectedEdge<V>> AdjacencyList<V, E> create(final Graph<V, E> g) {
		final MutableMap<V, DynamicArray<E>> index = GoodMutableMapFactory.getInstance().create();
		for (V v : g.getVertices())
			index.put(v, new DynamicArray<E>());
		for (E e : g.getEdges())
			index.get(e.from()).addToLast(e);
		return new AdjacencyList<V, E>() {
			@Override
			public Collection<V> getVertices() {
				return g.getVertices();
			}

			@Override
			public Iterable<E> getEdges(V from) {
				return index.get(from);
			}

			@Override
			public String toString() {
				String r = "Graph({" + IterableToString.toString(g.getVertices()) + "},{";
				for(V v : getVertices())
					r += IterableToString.toString(getEdges(v));
				return r + "})";
			}
		};
	}

}