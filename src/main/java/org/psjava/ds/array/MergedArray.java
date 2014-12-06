package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.ds.array.Array;
import org.psjava.ds.array.ArrayIterator;
import org.psjava.util.IterableToString;


public class MergedArray {

	public static <T> Array<T> wrap(final Array<T> left, final Array<T> right) {
		return new Array<T>() {
			public T get(int index) {
				if(index < left.size())
					return left.get(index);
				return right.get(index - left.size());
			}

			public int size() {
				return left.size() + right.size();
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

	private MergedArray() {}

}
