package org.psjava.algo.graph.dfs;

public class DFSVisitorBase<V, E> implements DFSVisitor<V, E> {
	@Override
	public void onDiscovered(V vertex, int depth) {
	}

	@Override
	public void onFinish(V vertex, int depth) {
	}

	@Override
	public void onBackEdgeFound(E edge) {
	}

	@Override
	public void onWalkDown(E edge) {
	}

	@Override
	public void onWalkUp(E downedEdge) {
	}
}
