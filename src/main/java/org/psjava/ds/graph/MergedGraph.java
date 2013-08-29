package org.psjava.ds.graph;

import org.psjava.ds.Collection;
import org.psjava.ds.set.InsertAllToSet;
import org.psjava.ds.set.MutableSet;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.javautil.MergedIterable;
import org.psjava.javautil.VarargsIterable;

public class MergedGraph {

	public static <W> DirectedWeightedGraph<W> create(final DirectedWeightedGraph<W> g1, final DirectedWeightedGraph<W> g2) {
		final MutableSet<Object> mergedv = GoodMutableSetFactory.getInstance().create();
		InsertAllToSet.insertAll(mergedv, g1.getVertices());
		InsertAllToSet.insertAll(mergedv, g2.getVertices());
	
		return new DirectedWeightedGraph<W>() {
			@Override
			public Collection<Object> getVertices() {
				return mergedv;
			}
	
			@SuppressWarnings("unchecked")
			@Override
			public Iterable<DirectedWeightedEdge<W>> getEdges() {
				return MergedIterable.wrap(VarargsIterable.create(g1.getEdges(), g2.getEdges()));
			}
		};
	}

	private MergedGraph() {
	}

}
