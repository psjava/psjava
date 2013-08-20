package org.psjava.ds.tree.segmenttree;

import org.psjava.ds.array.Array;
import org.psjava.math.BinaryOperator;
import org.psjava.math.Power;

public class RangeUpdatableSegmentTreeByLazyPropagation<T> implements RangeUpdatableSegmentTree<T> {

	public static final <T> RangeUpdatableSegmentTree<T> create(Array<T> initialData, BinaryOperator<T> operator) {
		return new RangeUpdatableSegmentTreeByLazyPropagation<T>(initialData, operator);
	}

	EnhancedRangeUpdatableSegmentTree<T, T> sub;

	RangeUpdatableSegmentTreeByLazyPropagation(Array<T> initialData, final BinaryOperator<T> operator) {
		sub = new EnhancedRangeUpdatableSegmentTree<T, T>(initialData, new EnhancedRangeUpdatableSegmentTreeOperator<T, T>() {
			@Override
			public T mergeRangeValue(T oldRangeValue, int rangeSize, T updateData) {
				return Power.calc(updateData, rangeSize, operator);
			}

			@Override
			public T mergeSingleValue(T v1, T v2) {
				return operator.calc(v1, v2);
			}

			@Override
			public T mergeUpdateData(T oldData, T newData) {
				return newData;
			}
		});
	}

	@Override
	public T query(int start, int end) {
		return sub.queryRange(start, end);
	}

	@Override
	public void update(int p, final T v) {
		updateRange(p, p + 1, v);
	}

	@Override
	public void updateRange(int start, int end, T value) {
		sub.updateRange(start, end, value);
	}

	@Override
	public String toString() {
		return sub.toString();
	}

}