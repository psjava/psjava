package org.psjava.javautil;

import org.psjava.math.ThomasWangHash;

public class IterableHash {

	public static <T> int hash(Iterable<T> iterable) {
		int r = 0;
		for(T v : iterable)
			r ^= ThomasWangHash.hash32bit(v.hashCode());
		return r;
	}

}
