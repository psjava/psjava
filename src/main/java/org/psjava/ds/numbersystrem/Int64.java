package org.psjava.ds.numbersystrem;

import org.psjava.algo.math.ThomasWangHash;
import org.psjava.util.EqualityTester;
import org.psjava.util.FactoryByInt;
import org.psjava.util.StrictEqualityTester;

public class Int64 {

	private static final CacheByIntegerRange<Int64> CACHE = new CacheByIntegerRange<Int64>(-256, 256, new FactoryByInt<Int64>() {
		@Override
		public Int64 create(int value) {
			return new Int64(value);
		}
	});

	public static Int64 valueOf(long v) {
		int casted = (int) v;
		if (v == casted && CACHE.inCache(casted))
			return CACHE.get(casted);
		else
			return new Int64(v);
	}

	final long v;

	private Int64(long v) {
		this.v = v;
	}

	public long toPrimitive() {
		return v;
	}

	@Override
	public boolean equals(Object obj) {
		return StrictEqualityTester.areEqual(this, obj, TESTER);
	}

	private final static EqualityTester<Int64> TESTER = new EqualityTester<Int64>() {
		@Override
		public boolean areEqual(Int64 o1, Int64 o2) {
			return o1.v == o2.v;
		}
	};

	@Override
	public int hashCode() {
		return ThomasWangHash.hash64bit(v);
	}

	@Override
	public String toString() {
		return Long.toString(v);
	}

}
