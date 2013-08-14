package org.psjava.ds.tree.segmenttree;

import org.psjava.ds.array.Array;
import org.psjava.math.BinaryOperator;

public class RangeUpdatableSegmentTreeFactory implements SegmentTreeFactory {

	private static RangeUpdatableSegmentTreeFactory instance = new RangeUpdatableSegmentTreeFactory();

	public static RangeUpdatableSegmentTreeFactory getInstance() {
		return instance;
	}

	@Override
	public <T> RangeUpdatableSegmentTree<T> create(Array<T> initialList, BinaryOperator<T> operator) {
		return RangeUpdatableSegmentTreeByLazyPropagation.create(initialList, operator);
	}

	private RangeUpdatableSegmentTreeFactory() {
	}

}
