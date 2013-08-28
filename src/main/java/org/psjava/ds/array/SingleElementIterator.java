package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.javautil.AssertStatus;
import org.psjava.javautil.ReadOnlyIterator;

public class SingleElementIterator {

	public static <T> Iterator<T> create(final T value) {
		return new ReadOnlyIterator<T>() {
			boolean read = false;

			@Override
			public boolean hasNext() {
				return !read;
			}

			@Override
			public T next() {
				AssertStatus.assertTrue(!read, "no item anymore");
				read = true;
				return value;
			}
		};
	}

	private SingleElementIterator() {
	}

}
