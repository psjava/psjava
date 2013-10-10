package org.psjava.ds.numbersystrem;

import java.util.Comparator;

public class Float64NumberSystem implements DivisableNumberSystem<Float64>, Comparator<Float64> {

	private static Float64NumberSystem INSTANCE = new Float64NumberSystem();

	public static Float64NumberSystem getInstance() {
		return INSTANCE;
	}

	private Float64NumberSystem() {
	}

	@Override
	public Float64 getOne() {
		return Float64.valueOf(1);
	}

	@Override
	public Float64 getZero() {
		return Float64.valueOf(0);
	}

	@Override
	public boolean isNegative(Float64 v) {
		return v.toPrimitive() < 0;
	}

	@Override
	public boolean isOne(Float64 v) {
		return v.toPrimitive() == 1;
	}

	@Override
	public boolean isPositive(Float64 v) {
		return v.toPrimitive() > 0;
	}

	@Override
	public boolean isZero(Float64 v) {
		return v.toPrimitive() == 0;
	}

	@Override
	public boolean areEqual(Float64 o1, Float64 o2) {
		return o1.toPrimitive() == o2.toPrimitive();
	}

	@Override
	public int compare(Float64 o1, Float64 o2) {
		return Double.compare(o1.toPrimitive(), o2.toPrimitive());
	}

	@Override
	public int getSign(Float64 v) {
		return Double.compare(v.toPrimitive(), 0);
	}

	@Override
	public Float64 add(Float64 v1, Float64 v2) {
		return Float64.valueOf(v1.toPrimitive() + v2.toPrimitive());
	}

	@Override
	public Float64 subtract(Float64 minuend, Float64 subtrahend) {
		return Float64.valueOf(minuend.toPrimitive() - subtrahend.toPrimitive());
	}

	@Override
	public Float64 divide(Float64 dividend, Float64 divisor) {
		return Float64.valueOf(dividend.toPrimitive() / divisor.toPrimitive());
	}

	@Override
	public Float64 multiply(Float64 v1, Float64 v2) {
		return Float64.valueOf(v1.toPrimitive() * v2.toPrimitive());
	}
}
