package org.psjava.ds.array;

import org.psjava.util.IterableToString;

import java.util.Iterator;

public class RotatedArray {
	public static <T> Array<T> wrap(final Array<T> array, final int startIndex) {
		return new Array<T>() {
			@Override
			public T get(int index) {
				return array.get((startIndex + index) % array.size());
			}

			@Override
			public int size() {
				return array.size();
			}

			@Override
			public boolean isEmpty() {
				return array.isEmpty();
			}

			@Override
			public Iterator<T> iterator() {
				return ArrayIterator.create(this);
			}

			@Override
			public String toString() {
				return IterableToString.toString(this);
			}
		};
	}

	private RotatedArray() {}
}
