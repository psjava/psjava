package org.psjava.math.ns;

import org.psjava.javautil.EqualityTester;
import org.psjava.javautil.FactoryByInt;
import org.psjava.javautil.StrictEqualityTester;
import org.psjava.math.ThomasWangHash;

public class Int32  {

	private static final CacheByIntegerRange<Int32> CACHE = new CacheByIntegerRange<Int32>(-256, 256, new FactoryByInt<Int32>() {
		@Override
		public Int32 create(int value) {
			return new Int32(value);
		}
	});

	public static Int32 valueOf(int v) {
		if(CACHE.inCache(v))
			return CACHE.get(v);
		else
			return new Int32(v);
	}
	
	public final int v; // TODO to private

	private Int32(int v) {
		this.v = v;
	}

	@Override
	public boolean equals(Object obj) {
		return StrictEqualityTester.areEqual(this, obj, TESTER);
	}

	private final static EqualityTester<Int32> TESTER = new EqualityTester<Int32>() {
		@Override
		public boolean areEqual(Int32 o1, Int32 o2) {
			return o1.v == o2.v;
		}
	};

	@Override
	public int hashCode() {
		return ThomasWangHash.hash32bit(v);
	}

	@Override
	public String toString() {
		return Integer.toString(v);
	}
}
