package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.javautil.IterableToString;



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
		};
	}

	private MutableArrayUsingJavaArray() {
	}

}
