package org.psjava.ds.tree.segmenttree;

public interface EnhancedRangeUpdatableSegmentTreeOperator<V, U> {
    V mergeSingleValue(V v1, V v2);

    V mergeRangeValue(V oldRangeValue, int rangeSize, U updateData);

    U mergeUpdateData(U oldData, U newData);
}
