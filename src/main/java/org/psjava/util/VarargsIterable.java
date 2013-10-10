package org.psjava.util;

import java.util.Iterator;

public class VarargsIterable {

	public static <T> Iterable<T> create(final T... data) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return VarargsIterator.create(data);
			}
		};
	}

	private VarargsIterable() {
	}

}
