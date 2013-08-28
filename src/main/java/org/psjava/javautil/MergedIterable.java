package org.psjava.javautil;

import java.util.Iterator;

public class MergedIterable<T> {

	public static <T> Iterable<T> wrap(final Iterable<? extends Iterable<? extends T>> iterables) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return MergedIterator.create(iterables);
			}
		};
	}

	private MergedIterable() {
	}

}
