package org.psjava.ds.tree.segmenttree;

import org.psjava.ds.array.Array;
import org.psjava.math.BinaryOperator;

public class SegmentTreeFactoryByArrayImplementation implements SegmentTreeFactory {

	@Override
	public <T> SegmentTree<T> create(Array<T> initialData, BinaryOperator<T> merger) {
		return new SegmentTreeByArrayImplementation<T>(initialData, merger);
	}
}