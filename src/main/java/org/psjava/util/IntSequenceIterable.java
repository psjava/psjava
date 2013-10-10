package org.psjava.util;

import java.util.Iterator;

public class IntSequenceIterable {
	public static Iterable<Integer> create(final int from, final int step, final int size) {
		return new Iterable<Integer>() {
			@Override
			public Iterator<Integer> iterator() {
				return IntSequenceIterator.create(from, step, size);
			}
		};
	}

	private IntSequenceIterable() {
	}
}