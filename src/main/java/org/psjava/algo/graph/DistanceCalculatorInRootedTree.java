package org.psjava.algo.graph;

import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.SingleSourceDFS;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.graph.NewGraphFromGraph;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.RootedTree;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.ds.math.BinaryOperator;
import org.psjava.ds.numbersystrem.AddInvert;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.ds.tree.segmenttree.SegmentTree;
import org.psjava.ds.tree.segmenttree.SegmentTreeFactory;
import org.psjava.util.VisitorStopper;

// TODO this is not used any problem. solve something to prove this.
public class DistanceCalculatorInRootedTree {

	private final LowestCommonAncestorAlgorithm lca;
	private final SegmentTreeFactory segmentTreeFactory;
	private final MutableMapFactory mapFactory;

	public DistanceCalculatorInRootedTree(LowestCommonAncestorAlgorithm lca, SegmentTreeFactory segmentTreeFactory, MutableMapFactory mapFactory) {
		this.lca = lca;
		this.segmentTreeFactory = segmentTreeFactory;
		this.mapFactory = mapFactory;
	}

	public <V, W> DistanceCalculatorInRootedTreeResult<V, W> calc(RootedTree<V, DirectedWeightedEdge<V, W>> tree, final AddableNumberSystem<W> ns) {
		final DynamicArray<W> pathWeights = DynamicArray.create();
		final MutableMap<V, Integer> discoverIndex = mapFactory.create();
		final MutableMap<V, Integer> indexOfWalkingDown = mapFactory.create();
		final MutableMap<V, Integer> indexOfWalkingUp = mapFactory.create();
		SingleSourceDFS.traverse(NewGraphFromGraph.createFromDirected(tree.oldGraph), tree.root, new DFSVisitorBase<V, DirectedWeightedEdge<V, W>>() {

			@Override
			public void onDiscovered(V vertex, int depth, VisitorStopper stopper) {
				int index = pathWeights.size();
				discoverIndex.add(vertex, index);
			}

			@Override
			public void onWalkDown(DirectedWeightedEdge<V, W> outEdge) {
				int index = pathWeights.size();
				indexOfWalkingDown.add(outEdge.to(), index);
				pathWeights.addToLast(outEdge.weight());
			}

			@Override
			public void onWalkUp(DirectedWeightedEdge<V, W> edge) {
				int index = pathWeights.size();
				indexOfWalkingUp.add(edge.to(), index);
				pathWeights.addToLast(AddInvert.calc(ns, edge.weight()));
			}
		});

		final SegmentTree<W> segmentTree = segmentTreeFactory.create(pathWeights, createAdder(ns));
		final LowestCommonAncestorQuerySession<V> lcaSession = lca.calc(tree);

		return new DistanceCalculatorInRootedTreeResult<V, W>() {
			@Override
			public W getDistance(V v1, V v2) {
				V ancestor = lcaSession.query(v1, v2);
				W r = ns.getZero();
				if (!v1.equals(ancestor))
					r = ns.add(r, segmentTree.query(discoverIndex.get(ancestor), discoverIndex.get(v1)));
				if (!v2.equals(ancestor))
					r = ns.add(r, segmentTree.query(discoverIndex.get(ancestor), discoverIndex.get(v2)));
				return r;
			}

			@Override
			public void modifyDistance(V v1, V v2, W w) {
				V child = (discoverIndex.get(v1) < discoverIndex.get(v2)) ? v2 : v1;
				segmentTree.update(indexOfWalkingDown.get(child), w);
				segmentTree.update(indexOfWalkingUp.get(child), AddInvert.calc(ns, w));
			}
		};
	}

	private static <T> BinaryOperator<T> createAdder(final AddableNumberSystem<T> ns) {
		return new BinaryOperator<T>() {
			@Override
			public T calc(T d1, T d2) {
				return ns.add(d1, d2);
			}
		};
	}
}