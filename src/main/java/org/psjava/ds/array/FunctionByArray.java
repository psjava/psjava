package org.psjava.ds.array;

import org.psjava.ds.math.Function;

public class FunctionByArray {

	public static <T> Function<Integer, T> wrap(final Array<T> array) {
		return new Function<Integer, T>() {
			@Override
			public T get(Integer input) {
				return array.get(input);
			}
		};
	}
	
	private FunctionByArray() {
	}

}
