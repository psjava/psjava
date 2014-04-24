package org.psjava.algo.graph;

import java.util.Comparator;

import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.SingleSourceDFS;
import org.psjava.algo.sequence.rmq.RangeMinimumQueryResult;
import org.psjava.algo.sequence.rmq.RangeMinimumQuery;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.LastInArray;
import org.psjava.ds.graph.AdjacencyListFromGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.RootedTree;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.util.Pair;
import org.psjava.util.VisitorStopper;

public class LowestCommonAncestor {

	private MutableMapFactory mapFactory;
	private RangeMinimumQuery rmq;

	public LowestCommonAncestor(RangeMinimumQuery rmq, MutableMapFactory mapFactory) {
		this.rmq = rmq;
		this.mapFactory = mapFactory;
	}

	public <V, E extends DirectedEdge<V>> LowestCommonAncestorPreprecessed<V> calc(RootedTree<V, E> tree) {
		final MutableMap<Object, Integer> discoverIndex = mapFactory.create();
		final DynamicArray<Pair<V, Integer>> history = DynamicArray.create(); // stores vertex and depth

		SingleSourceDFS.traverse(AdjacencyListFromGraph.create(tree.graph), tree.root, new DFSVisitorBase<V, E>() {
			@Override
			public void onDiscovered(V vertex, int depth, VisitorStopper stopper) {
				discoverIndex.put(vertex, history.size());
				history.addToLast(Pair.create(vertex, depth));
			}

			@Override
			public void onWalkUp(E downedEdge) {
				int lastDepth = LastInArray.getLast(history).v2;
				history.addToLast(Pair.create(downedEdge.from(), lastDepth - 1));
			}
		});

		final RangeMinimumQueryResult rmqResult = rmq.preprocess(history, new Comparator<Pair<V, Integer>>() {
			@Override
			public int compare(Pair<V, Integer> o1, Pair<V, Integer> o2) {
				return o1.v2 - o2.v2;
			}
		});

		return new LowestCommonAncestorPreprecessed<V>() {
			@Override
			public V query(V v1, V v2) {
				int i1 = discoverIndex.get(v1);
				int i2 = discoverIndex.get(v2);
				return history.get(rmqResult.getIndex(Math.min(i1, i2), Math.max(i1, i2) + 1)).v1;
			}
		};
	}
}
