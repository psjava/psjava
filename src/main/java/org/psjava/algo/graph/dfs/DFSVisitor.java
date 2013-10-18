package org.psjava.algo.graph.dfs;

import org.psjava.util.VisitorStopper;

public interface DFSVisitor<V, E> {
	void onDiscovered(V vertex, int depth, VisitorStopper stopper);

	void onFinish(V vertex, int depth);

	void onBackEdgeFound(E edge);

	void onWalkDown(E edge);

	void onWalkUp(E downedEdge);
}