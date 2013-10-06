package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.array.AddToLastAll;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;

public class AdjacencyListOfDirectedGraph<V, E extends DirectedEdge<V>> {

	public static <V, E extends DirectedEdge<V>> AdjacencyListOfDirectedGraph<V, E> create(Graph<V, E> g) {
		return new AdjacencyListOfDirectedGraph<V, E>(g);
	}

	private final DynamicArray<V> vertices = DynamicArray.create();
	private final MutableMap<V, DynamicArray<E>> index = GoodMutableMapFactory.getInstance().create();

	private AdjacencyListOfDirectedGraph(Graph<V, E> g) {
		AddToLastAll.add(vertices, g.getVertices());
		for (V v : g.getVertices())
			index.put(v, new DynamicArray<E>());
		for (E e : g.getEdges())
			index.get(e.from()).addToLast(e);
	}

	public Collection<V> getVertices() {
		return vertices;
	}

	public Iterable<E> getEdges(V from) {
		return index.get(from);
	}
}