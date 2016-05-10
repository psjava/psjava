package org.psjava.util;

import org.psjava.ds.array.Array;
import org.psjava.ds.array.MutableArrayFromIterable;

public class SubSetIterable {

	public static <T> Iterable<Iterable<T>> create(final Iterable<T> superSet) {
		final Array<T> array = MutableArrayFromIterable.create(superSet);
		AssertStatus.assertTrue(array.size() <= 30, "too big set to iterate sub set");
		return ConvertedDataIterable.create(ZeroTo.get(1 << array.size()), new Converter<Integer, Iterable<T>>() {
			@Override
			public Iterable<T> convert(final Integer bits) {
				return ConvertedDataIterable.create(FilteredIterable.create(ZeroTo.get(array.size()), new DataFilter<Integer>() {
					@Override
					public boolean isAccepted(Integer index) {
						return IntBitUtil.get(bits, index);
					}
				}), new Converter<Integer, T>() {
					@Override
					public T convert(Integer index) {
						return array.get(index);
					}
				});
			}
		});
	}

	private SubSetIterable() {
	}
}
