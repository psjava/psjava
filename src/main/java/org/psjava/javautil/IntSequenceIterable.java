package org.psjava.javautil;

import java.util.Iterator;

public class IntSequenceIterable {
	public static Iterable<Integer> create(final int from, final int step, final int size) {
		return new Iterable<Integer>() {
			@Override
			public Iterator<Integer> iterator() {
				return new ReadOnlyIterator<Integer>() {
					int nextIndex = 0;
					@Override
					public boolean hasNext() {
						return nextIndex < size;
					}
					@Override
					public Integer next() {
						return from + step * (nextIndex++);
					}
				};
			}
		};
	}

	private IntSequenceIterable() {
	}
}