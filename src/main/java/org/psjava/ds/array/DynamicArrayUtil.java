package org.psjava.ds.array;

public class DynamicArrayUtil {

	public static <T> void addToLast(DynamicArray<T> dynamicArray, Iterable<? extends T> values) {
		for (T v : values)
			dynamicArray.addToLast(v);
	}

}
