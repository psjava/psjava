package org.psjava.util;

import java.util.Iterator;

public class ConvertedDataIterable {

	public static <T1, T2> Iterable<T2> create(final Iterable<T1> outerIterable, final DataConverter<T1, T2> converter) {
		return new Iterable<T2>() {
			@Override
			public Iterator<T2> iterator() {
				return ConvertedDataIterator.create(outerIterable.iterator(), converter);
			}

			@Override
			public String toString() {
				return IterableToString.toString(this);
			}
		};
	}

	private ConvertedDataIterable() {
	}
}