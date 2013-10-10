package org.psjava.ds.set;

import org.psjava.util.VarargsIterable;

public class SetFromVarargs {
	public static <T> Set<T> create(T... values) {
		return SetFromIterable.create(VarargsIterable.create(values));
	}

	private SetFromVarargs() {
	}
}
