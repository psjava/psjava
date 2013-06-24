package org.psjava.javautil;


public class ArrayIterable {
	
	public static <T> Iterable<T> create(final T... data) {
		return ConvertedDataIterable.create(ZeroTo.get(data.length), new DataConverter<Integer, T>() {
			@Override
			public T convert(Integer v) {
				return data[v];
			}
		});
	}

	private ArrayIterable() {
	}

}
