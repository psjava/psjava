package org.psjava.ds.graph;


import org.psjava.ds.Collection;

public class MutableCapacityGraph<V, F> implements Graph<V, CapacityEdge<V, F>> {

	public static <V, F> MutableCapacityGraph<V, F> create() {
		return new MutableCapacityGraph<V, F>();
	}

	private final MutableGraph<V, CapacityEdge<V, F>> g = MutableGraph.create();

	@Override
	public Iterable<CapacityEdge<V, F>> getEdges() {
		return g.getEdges();
	}

	@Override
	public Collection<V> getVertices() {
		return g.getVertices();
	}

	public void insertVertex(V v) {
		g.insertVertex(v);
	}

	public void addEdge(V from, V to, F capacity) {
		g.addEdge(SimpleCapacityEdge.create(from, to, capacity));
	}
}
