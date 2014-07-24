package org.psjava.algo.graph;

import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.UndirectedEdge;
import org.psjava.ds.set.DisjointSet;
import org.psjava.ds.set.MutableSet;
import org.psjava.goods.GoodDisjointSet;
import org.psjava.goods.GoodMutableSetFactory;

public class NumberOfConnectedComponents {

	public static <V, E extends UndirectedEdge<V>> int calc(Graph<V, E> g) {
		DisjointSet<V> dset = GoodDisjointSet.create();
		for (V v : g.getVertices())
			dset.makeSet(v);
		for (E e : g.getEdges())
			dset.union(e.v1(), e.v2());
		MutableSet<V> finalReps = GoodMutableSetFactory.getInstance().create();
		for (V v : g.getVertices())
			finalReps.addIfAbsent(dset.find(v));
		return finalReps.size();
	}

	private NumberOfConnectedComponents() {
	}
}
