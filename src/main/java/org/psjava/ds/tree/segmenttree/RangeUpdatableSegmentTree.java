package org.psjava.ds.tree.segmenttree;

import org.psjava.ds.array.PSArray;
import org.psjava.formula.Power;

import java.util.function.BinaryOperator;

public class RangeUpdatableSegmentTree<T>  {

    public static <T> RangeUpdatableSegmentTree<T> create(PSArray<T> initialData, BinaryOperator<T> operator) {
        return new RangeUpdatableSegmentTree<T>(initialData, operator);
    }

    private LazyPropagatingSegmentTree<T, T> sub;

    private RangeUpdatableSegmentTree(PSArray<T> initialData, final BinaryOperator<T> operator) {
        sub = new LazyPropagatingSegmentTree<T, T>(initialData, new EnhancedRangeUpdatableSegmentTreeOperator<T, T>() {
            @Override
            public T mergeRangeValue(T oldRangeValue, int rangeSize, T updateData) {
                return Power.calc(updateData, rangeSize, operator);
            }

            @Override
            public T mergeSingleValue(T v1, T v2) {
                return operator.apply(v1, v2);
            }

            @Override
            public T mergeUpdateData(T oldData, T newData) {
                return newData;
            }
        });
    }

    public T query(int start, int end) {
        return sub.queryRange(start, end);
    }

    public void update(int start, int end, T value) {
        sub.updateRange(start, end, value);
    }

    @Override
    public String toString() {
        return sub.toString();
    }

}