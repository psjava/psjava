package org.psjava.ds.array;

import org.psjava.ds.array.Array;
import org.psjava.ds.array.ArrayIterator;
import org.psjava.util.IterableToString;

import java.util.Iterator;

public class ReversedArray {
	public static <T> Array<T> wrap(final Array<T> array) {
		return new Array<T>() {
			@Override
			public T get(int index) {
				return array.get(array.size() - 1 - index);
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
}
