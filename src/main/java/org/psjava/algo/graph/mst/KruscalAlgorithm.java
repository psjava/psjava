package org.psjava.algo.graph.mst;

import java.util.Comparator;

import org.psjava.algo.graph.NumberOfConnectedComponents;
import org.psjava.algo.sequence.sort.SortingAlgorithm;
import org.psjava.ds.array.AddToLastAll;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.graph.MutableOldGraph;
import org.psjava.ds.graph.OldGraph;
import org.psjava.ds.graph.UndirectedWeightedEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.ds.set.DisjointSet;
import org.psjava.ds.set.MakeSetAll;
import org.psjava.goods.GoodDisjointSet;
import org.psjava.util.AssertStatus;

public class KruscalAlgorithm {

	public static MinimumSpanningTreeAlgorithm getInstance(final SortingAlgorithm sort) {
		return new MinimumSpanningTreeAlgorithm() {
			@Override
			public <W, V, E extends UndirectedWeightedEdge<V, W>> OldGraph<V, E> calc(OldGraph<V, E> oldGraph, final AddableNumberSystem<W> ns) {
				AssertStatus.assertTrue(NumberOfConnectedComponents.calc(oldGraph) <= 1);

				DynamicArray<E> edges = DynamicArray.create();
				AddToLastAll.add(edges, oldGraph.getEdges());

				sort.sort(edges, new Comparator<E>() {
					@Override
					public int compare(E e1, E r2) {
						return ns.compare(e1.weight(), r2.weight());
					}
				});

				DisjointSet<V> dset = GoodDisjointSet.create();
				MakeSetAll.make(dset, oldGraph.getVertices());

				MutableOldGraph<V, E> result = MutableOldGraph.create();
				for (E e : edges) {
					if (dset.find(e.v1()) != dset.find(e.v2())) {
						result.addEdge(e);
						dset.union(e.v1(), e.v2());
					}
				}
				return result;
			}
		};
	}

	private KruscalAlgorithm() {
	}
}
