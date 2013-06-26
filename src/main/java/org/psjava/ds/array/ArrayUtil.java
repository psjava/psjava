package org.psjava.ds.array;


public class ArrayUtil {

	public static <T> T getLast(Array<T> a) {
		return a.get(a.size()-1);
	}

	public static <T> T getFirst(Array<T> a) {
		return a.get(0);
	}

}
