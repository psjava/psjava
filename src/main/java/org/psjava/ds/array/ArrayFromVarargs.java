package org.psjava.ds.array;

public class ArrayFromVarargs {
	public static <T> Array<T> create(T... values) {
		return MutableArrayFromValues.create(values);
	}

	private ArrayFromVarargs() {
	}
}
