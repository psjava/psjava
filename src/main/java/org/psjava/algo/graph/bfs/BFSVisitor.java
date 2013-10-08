package org.psjava.algo.graph.bfs;


public interface BFSVisitor<V, E> {
	void onDiscover(V vertex, int depth, BFSStopper stopper);

	void onWalk(E e);
}
