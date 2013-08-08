package org.psjava.ds.tree;

public interface RangeUpdatableSegmentTree<T> extends SegmentTree<T> {
	void updateRange(int start, int end, T value);
}