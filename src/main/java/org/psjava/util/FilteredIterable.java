package org.psjava.util;

import java.util.Iterator;

public class FilteredIterable {

	public static <T> Iterable<T> create(final Iterable<? extends T> original, final Filter<T> filter) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return FilteredIterator.create(original.iterator(), filter);
			}
		};
	}

	private FilteredIterable() {
	}

}