package org.psjava.ds.tree.segmenttree;

public interface RangeUpdatableSegmentTree<T> extends SegmentTree<T> {
	void updateRange(int start, int end, T updateData);
}