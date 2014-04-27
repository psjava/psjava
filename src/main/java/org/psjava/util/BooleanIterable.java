package org.psjava.util;

import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromValues;

public class BooleanIterable {

	private static final MutableArray<Boolean> INSTANCE = MutableArrayFromValues.create(Boolean.FALSE, Boolean.TRUE);

	public static Iterable<Boolean> getInstance() {
		return INSTANCE;
	}

	private BooleanIterable() {
	}

}
