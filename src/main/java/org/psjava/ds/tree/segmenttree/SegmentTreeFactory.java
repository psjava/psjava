package org.psjava.ds.tree.segmenttree;

import org.psjava.ds.array.Array;
import org.psjava.math.BinaryOperator;

public interface SegmentTreeFactory {

	<T> SegmentTree<T> create(Array<T> initialList, BinaryOperator<T> operator);

}
