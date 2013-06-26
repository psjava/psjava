package org.psjava.math.ns;

import org.psjava.javautil.EqualityTester;
import org.psjava.javautil.StrictEqualityTester;
import org.psjava.math.ThomasWangHash;

public class Float64 {

	public static Float64 valueOf(double value) {
		return new Float64(value);
	}

	private double value;

	private Float64(double value) {
		this.value = value;
	}

	public double toPrimitive() {
		return value;
	}

	@Override
	public int hashCode() {
		return ThomasWangHash.hash64bit(Double.doubleToLongBits(value));
	}

	@Override
	public boolean equals(Object obj) {
		return StrictEqualityTester.areEqual(this, obj, EQ_TESTER);
	}

	private static EqualityTester<Float64> EQ_TESTER = new EqualityTester<Float64>() {
		@Override
		public boolean areEqual(Float64 o1, Float64 o2) {
			return o1.value == o2.value;
		}
	};

	public String toString() {
		return Double.toString(value);
	}

}
