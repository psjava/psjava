package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.javautil.IterableToString;

public class UniformArray {

	public static <T> Array<T> create(final T value, final int size) {
		return new Array<T>() {
			@Override
			public T get(int index) {
				return value;
			}

			@Override
			public int size() {
				return size;
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

	private UniformArray() {
	}

}
