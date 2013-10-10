package org.psjava.util;

import java.util.Iterator;

public class IntSequenceIterator {

	public static Iterator<Integer> create(final int start, final int step, final int size) {
		return new ReadOnlyIterator<Integer>() {
			int nextIndex = 0;
	
			@Override
			public boolean hasNext() {
				return nextIndex < size;
			}
	
			@Override
			public Integer next() {
				return start + step * (nextIndex++);
			}
		};
	}

	private IntSequenceIterator() {
	}

}
