package org.psjava.ds.array;

public class AddToLastAll {

	public static <T> void add(DynamicArray<T> dynamicArray, Iterable<? extends T> values) {
		for (T v : values)
			dynamicArray.addToLast(v);
	}

}
