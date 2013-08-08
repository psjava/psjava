package org.psjava.ds.tree;

import org.psjava.ds.array.Array;
import org.psjava.math.BinaryOperator;

public class SegmentTreeByArrayFactory implements SegmentTreeFactory {

	@Override
	public <T> SegmentTree<T> create(Array<T> initialData, BinaryOperator<T> merger) {
		return new SegmentTreeByArray<T>(initialData, merger);
	}
}