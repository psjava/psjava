package org.psjava.javautil;

import java.util.Iterator;

import org.psjava.ds.array.ArrayFromValues;
import org.psjava.ds.array.ArrayIterator;

public class VarargsIterator {

	public static <T> Iterator<T> create(final T... data) {
		return ArrayIterator.create(ArrayFromValues.create(data));
	}

	private VarargsIterator() {
	}

}
