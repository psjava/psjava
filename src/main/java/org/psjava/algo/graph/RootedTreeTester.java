package org.psjava.algo.graph;

import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.SingleSourceDFS;
import org.psjava.ds.graph.NewGraphFromGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.OldGraph;
import org.psjava.util.DataKeeper;
import org.psjava.util.VisitorStopper;

public class RootedTreeTester {

	public static <E extends DirectedEdge<V>, V> boolean is(OldGraph<V, E> oldGraph, V root) {
		if (CycleDetection.hasCycle(oldGraph))
			return false;
		final DataKeeper<Integer> visitCount = DataKeeper.create(0);
		SingleSourceDFS.traverse(NewGraphFromGraph.createFromDirected(oldGraph), root, new DFSVisitorBase<V, E>() {
			@Override
			public void onDiscovered(V vertex, int depth, VisitorStopper stopper) {
				visitCount.set(visitCount.get() + 1);
			}
		});
		if (visitCount.get() != oldGraph.getVertices().size())
			return false;
		return true;
	}

	private RootedTreeTester() {
	}

}
