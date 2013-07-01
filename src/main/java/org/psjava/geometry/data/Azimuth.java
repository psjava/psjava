package org.psjava.geometry.data;

import org.psjava.javautil.EqualityTester;
import org.psjava.javautil.StrictEqualityTester;
import org.psjava.math.ThomasWangHash;

public class Azimuth implements EqualityTester<Azimuth> {

	private static final double DOUBLE_PI = Math.PI + Math.PI;

	public static Azimuth create(double radian) {
		return new Azimuth(radian);
	}

	private final double radian; // 0 =< a < 2pi

	public Azimuth(double radian) {
		if (Double.isNaN(radian))
			throw new IllegalArgumentException("Direction cannot be NaN");
		this.radian = adjustRadian(radian);
	}

	private double adjustRadian(double radian) {
		radian = radian % DOUBLE_PI;
		if (radian < 0)
			radian += DOUBLE_PI;
		if (radian >= DOUBLE_PI)
			radian = 0;
		return radian;
	}

	public double radian() {
		return radian;
	}

	@Override
	public final boolean equals(Object v) {
		return StrictEqualityTester.areEqual(this, v, this);
	}

	@Override
	public boolean areEqual(Azimuth o1, Azimuth o2) {
		return o1.radian == o2.radian;
	}

	@Override
	public final int hashCode() {
		return ThomasWangHash.hash64bit(Double.doubleToLongBits(radian));
	}

	public String toString() {
		return "Dir(" + String.format("%.2f", radian) + "pi)";
	}

}
