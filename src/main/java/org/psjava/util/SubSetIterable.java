package org.psjava.util;

import org.psjava.ds.array.Array;
import org.psjava.ds.array.MutableArrayFromIterable;

public class SubSetIterable {

	public static <T> Iterable<Iterable<T>> create(final Iterable<T> superSet) {
		final Array<T> seq = MutableArrayFromIterable.create(superSet);
		AssertStatus.assertTrue(seq.size() <= 30, "too big set to iterate");
		return ConvertedDataIterable.create(ZeroTo.get(1 << seq.size()), new DataConverter<Integer, Iterable<T>>() {
			@Override
			public Iterable<T> convert(final Integer v) {
				return ConvertedDataIterable.create(FilteredIterable.create(ZeroTo.get(seq.size()), new DataFilter<Integer>() {
					@Override
					public boolean isAccepted(Integer i) {
						return IntBitUtil.get(v, i);
					}
				}), new DataConverter<Integer, T>() {
					@Override
					public T convert(Integer v) {
						return seq.get(v);
					}
				});
			}
		});
	}

	private SubSetIterable() {
	}
}
