package org.psjava.ds.graph;

import org.psjava.ds.Collection;

@Deprecated
public class MutableCapacityOldGraph<V, F> implements OldGraph<V, CapacityEdge<V, F>> {

	public static <V, F> MutableCapacityOldGraph<V, F> create() {
		return new MutableCapacityOldGraph<V, F>();
	}

	private final MutableOldGraph<V, CapacityEdge<V, F>> g = MutableOldGraph.create();

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

	@Override
	public String toString() {
		return GraphToString.toString(this);
	}
}
