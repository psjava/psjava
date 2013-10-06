package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.ds.Collection;

public class SingleElementCollection<T> {

	public static <T> Collection<T> create(final T value) {
		return new Collection<T>() {
			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public Iterator<T> iterator() {
				return SingleElementIterator.create(value);
			}

			@Override
			public int size() {
				return 1;
			}
		};
	}

	private SingleElementCollection() {
	}
}
