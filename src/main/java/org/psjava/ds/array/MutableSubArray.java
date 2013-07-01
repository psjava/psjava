package org.psjava.ds.array;

import java.util.Iterator;


public class MutableSubArray {
	public static <T> MutableArray<T> create(final MutableArray<T> original, final int start, final int size) {
		return new MutableArray<T>() {
			@Override
			public T get(int index) {
				return original.get(start + index);
			}
			@Override
			public void set(int index, T value) {
				original.set(start + index, value);				
			}
			@Override
			public boolean isEmpty() {
				return size == 0;
			}
			@Override
			public Iterator<T> iterator() {
				return ArrayIterator.create(this);
			}
			@Override
			public int size() {
				return size;
			}			
		};
	}
}
