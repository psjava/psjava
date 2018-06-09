package org.psjava.ds.tree.segmenttree;

import org.psjava.ds.array.PSArray;
import org.psjava.ds.math.BinaryOperator;

public interface SegmentTreeFactory {

    <T> SegmentTree<T> create(PSArray<T> initialList, BinaryOperator<T> operator);

}
