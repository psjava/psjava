package org.psjava.ds.array;

public class LastInArray {

	public static <T> T getLast(Array<T> a) {
		return a.get(a.size() - 1);
	}

	private LastInArray() {
	}

}
