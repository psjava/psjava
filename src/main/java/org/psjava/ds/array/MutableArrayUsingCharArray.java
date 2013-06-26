package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.javautil.IterableToString;



public class MutableArrayUsingCharArray {
	
	public static MutableArray<Character> create(final char[] a) {
		final int n = a.length;
		return new MutableArray<Character>() {

			public Character get(int i) {
				return a[i];
			}

			public void set(int i, Character v) {
				a[i] = v;
			}

			public int size() {
				return n;
			}

			@Override
			public boolean isEmpty() {
				return size() == 0;
			}

			@Override
			public Iterator<Character> iterator() {
				return ArrayIterator.create(this);
			}

			@Override
			public String toString() {
				return IterableToString.toString(this);
			}

		};
	}

	private MutableArrayUsingCharArray() {
	}

}
