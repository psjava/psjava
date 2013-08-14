package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.javautil.IterableToString;



public class MutableArrayUsingLongArray {
	
	public static MutableArray<Long> wrap(final long[] a) {
		return new MutableArray<Long>() {
			@Override
			public Long get(int i) {
				return a[i];
			}

			@Override
			public void set(int i, Long v) {
				a[i] = v;
			}

			@Override
			public int size() {
				return a.length;
			}

			@Override
			public final boolean isEmpty() {
				return size() == 0;
			}

			@Override
			public final Iterator<Long> iterator() {
				return ArrayIterator.create(this);
			}

			@Override
			public final String toString() {
				return IterableToString.toString(this);
			}
		};
	}

}
