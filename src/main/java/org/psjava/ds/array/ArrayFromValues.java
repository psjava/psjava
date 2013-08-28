package org.psjava.ds.array;

public class ArrayFromValues {
	public static <T> Array<T> create(T... values) {
		return MutableArrayFromValues.create(values);
	}
}
