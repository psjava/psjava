package org.psjava.algo.graph.dfs;

public interface DFSVisitor<V, E> {
	void onDiscovered(V vertex, int depth);

	void onFinish(V vertex, int depth);

	void onBackEdgeFound(E edge);

	void onWalkDown(E edge);

	void onWalkUp(E downedEdge);
}