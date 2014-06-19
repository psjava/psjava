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
import org.psjava.util.VisitorStopper;

public class LowestCommonAncestor {

	private MutableMapFactory mapFactory;
	private RangeMinimumQuery rmq;

	public LowestCommonAncestor(RangeMinimumQuery rmq, MutableMapFactory mapFactory) {
		this.rmq = rmq;
		this.mapFactory = mapFactory;
	}

	private static class HistoryItem<V> {
		final V vertex;
		final int depth;

		public HistoryItem(V v, int depth) {
			this.vertex = v;
			this.depth = depth;
		}
	}

	public <V, E extends DirectedEdge<V>> LowestCommonAncestorPreprecessed<V> calc(RootedTree<V, E> tree) {
		final MutableMap<Object, Integer> discoverIndex = mapFactory.create();
		final DynamicArray<HistoryItem<V>> history = DynamicArray.create();

		SingleSourceDFS.traverse(AdjacencyListFromGraph.create(tree.graph), tree.root, new DFSVisitorBase<V, E>() {
			@Override
			public void onDiscovered(V vertex, int depth, VisitorStopper stopper) {
				discoverIndex.put(vertex, history.size());
				history.addToLast(new HistoryItem<V>(vertex, depth));
			}

			@Override
			public void onWalkUp(E downedEdge) {
				int lastDepth = LastInArray.getLast(history).depth;
				history.addToLast(new HistoryItem<V>(downedEdge.from(), lastDepth - 1));
			}
		});

		final RangeMinimumQueryResult rmqResult = rmq.preprocess(history, new Comparator<HistoryItem<V>>() {
			@Override
			public int compare(HistoryItem<V> o1, HistoryItem<V> o2) {
				return o1.depth - o2.depth;
			}
		});

		return new LowestCommonAncestorPreprecessed<V>() {
			@Override
			public V query(V v1, V v2) {
				int i1 = discoverIndex.get(v1);
				int i2 = discoverIndex.get(v2);
				return history.get(rmqResult.getIndex(Math.min(i1, i2), Math.max(i1, i2) + 1)).vertex;
			}
		};
	}
}
