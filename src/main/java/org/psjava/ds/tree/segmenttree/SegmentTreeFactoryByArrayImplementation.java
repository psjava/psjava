package org.psjava.ds.tree.segmenttree;

import org.psjava.ds.array.Array;
import org.psjava.ds.math.BinaryOperator;

public class SegmentTreeFactoryByArrayImplementation {

	public static SegmentTreeFactory getInstance() {
		return new SegmentTreeFactory() {
			@Override
			public <T> SegmentTree<T> create(Array<T> initialList, BinaryOperator<T> operator) {
				return new SegmentTreeByArrayImplementation<T>(initialList, operator);
			}
		};
	}

	private SegmentTreeFactoryByArrayImplementation() {
	}

}