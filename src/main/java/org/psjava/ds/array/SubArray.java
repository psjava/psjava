package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.javautil.IterableToString;

public class SubArray {

	public static <T> Array<T> wrap(final Array<T> original, final int start, final int end) {
		return new Array<T>() {
			@Override
			public T get(int index) {
				return original.get(start + index);
			}

			@Override
			public int size() {
				return end - start;
			}

			@Override
			public final boolean isEmpty() {
				return size() == 0;
			}

			@Override
			public final Iterator<T> iterator() {
				return ArrayIterator.create(this);
			}

			@Override
			public final String toString() {
				return IterableToString.toString(this);
			}
		};
	}

}
