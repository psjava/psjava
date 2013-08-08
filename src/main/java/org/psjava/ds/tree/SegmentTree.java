package org.psjava.ds.tree;

public interface SegmentTree<T> {

	T query(int start, int end);

	void update(int position, T value);

}