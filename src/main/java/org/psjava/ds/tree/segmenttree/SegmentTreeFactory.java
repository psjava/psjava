package org.psjava.ds.tree.segmenttree;

import org.psjava.ds.array.PSArray;

import java.util.function.BinaryOperator;

public interface SegmentTreeFactory {

    <T> SegmentTree<T> create(PSArray<T> initialList, BinaryOperator<T> operator);

}
