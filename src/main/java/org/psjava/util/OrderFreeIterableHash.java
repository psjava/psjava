package org.psjava.util;

import org.psjava.algo.math.ThomasWangHash;

public class OrderFreeIterableHash {

	public static <T> int hash(Iterable<T> iterable) {
		int r = 0;
		for (T v : iterable)
			r ^= ThomasWangHash.hash32bit(v.hashCode());
		return r;
	}

	private OrderFreeIterableHash() {
	}

}
