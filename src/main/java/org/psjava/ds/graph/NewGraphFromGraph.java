package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.map.Map;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.util.IterableToString;

@Deprecated
public class NewGraphFromGraph {

	public static <V, E extends DirectedEdge<V>> Graph<V, E> createFromDirected(final OldGraph<V, E> g) {
		Map<V, DynamicArray<E>> index = initIndexMap(g.getVertices());
		for (E e : g.getEdges())
			index.get(e.from()).addToLast(e);
		return create(g.getVertices(), index);
	}

	public static <V, E extends UndirectedEdge<V>> Graph<V, E> createFromUndirected(final OldGraph<V, E> g) {
		Map<V, DynamicArray<E>> index = initIndexMap(g.getVertices());
		for (E e : g.getEdges()) {
			index.get(e.v1()).addToLast(e);
			index.get(e.v2()).addToLast(e);
		}
		return create(g.getVertices(), index);
	}

	private static <V, E> Map<V, DynamicArray<E>> initIndexMap(final Collection<V> vertices) {
		MutableMap<V, DynamicArray<E>> index = GoodMutableMapFactory.getInstance().create();
		for (V v : vertices)
			index.add(v, new DynamicArray<E>());
		return index;
	}

	private static <V, E> Graph<V, E> create(final Collection<V> vertices, final Map<V, DynamicArray<E>> index) {
		return new Graph<V, E>() {
			@Override
			public Collection<V> getVertices() {
				return vertices;
			}

			@Override
			public Iterable<E> getEdges(V from) {
				return index.get(from);
			}

			@Override
			public String toString() {
				String r = "Graph({" + IterableToString.toString(vertices) + "},{";
				for (V v : getVertices())
					r += IterableToString.toString(getEdges(v));
				return r + "})";
			}
		};
	}

	private NewGraphFromGraph() {
	}

}