package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.util.EqualityTester;
import org.psjava.util.IterableEqualityTester;
import org.psjava.util.IterableHash;
import org.psjava.util.IterableToString;
import org.psjava.util.StrictEqualityTester;

public class MutableArrayUsingJavaArray {

	public static <T> MutableArray<T> create(final T[] a) {
		return new MutableArray<T>() {
			@Override
			public T get(int p) {
				return a[p];
			}

			@Override
			public void set(int p, T v) {
				a[p] = v;
			}

			@Override
			public int size() {
				return a.length;
			}

			@Override
			public boolean isEmpty() {
				return a.length == 0;
			}

			@Override
			public Iterator<T> iterator() {
				return ArrayIterator.create(this);
			}

			@Override
			public String toString() {
				return IterableToString.toString(this);
			}

			@Override
			public boolean equals(Object obj) {
				return StrictEqualityTester.areEqual(this, obj, new EqualityTester<MutableArray<T>>() {
					@Override
					public boolean areEqual(MutableArray<T> o1, MutableArray<T> o2) {
						return IterableEqualityTester.areEqual(o1, o2);
					}
				});
			}

			@Override
			public int hashCode() {
				return IterableHash.hash(this);
			}
		};
	}

	private MutableArrayUsingJavaArray() {
	}

}
