package org.psjava.ds.array;

public class AddToLastAll {

	public static <T> void add(DynamicArray<T> target, Iterable<? extends T> values) {
		for (T v : values)
			target.addToLast(v);
	}

}
