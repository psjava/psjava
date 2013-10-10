package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.util.IterableToString;



public class MutableArrayUsingBooleanArray {
	
	public static MutableArray<Boolean> create(final boolean[] a) {
		return new MutableArray<Boolean>() {
			public Boolean get(int i) {
				return a[i];
			}

			public void set(int i, Boolean v) {
				a[i] = v;
			}

			public int size() {
				return a.length;
			}

			@Override
			public boolean isEmpty() {
				return size() == 0;
			}

			@Override
			public Iterator<Boolean> iterator() {
				return ArrayIterator.create(this);
			}

			@Override
			public String toString() {
				return IterableToString.toString(this);
			}
		};
	}
	
	private MutableArrayUsingBooleanArray() {
	}

}
