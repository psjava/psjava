package org.psjava.ds.numbersystrem;

public class Int64NumberSystem implements IntegerDivisableNumberSystem<Int64> {

	public Int64 valueOf(long v) {
		return Int64.valueOf(v);
	}

	@Override
	public int compare(Int64 o1, Int64 o2) {
		if (o1.v > o2.v)
			return 1;
		else if (o1.v < o2.v)
			return -1;
		else
			return 0;
	}

	@Override
	public Int64 getZero() {
		return Int64.valueOf(0);
	}

	@Override
	public boolean isPositive(Int64 v) {
		return v.v > 0;
	}

	@Override
	public boolean isZero(Int64 v) {
		return v.v == 0;
	}

	@Override
	public boolean isNegative(Int64 v) {
		return v.v < 0;
	}

	@Override
	public int getSign(Int64 v) {
		return Long.signum(v.v);
	}
	
	@Override
	public boolean areEqual(Int64 o1, Int64 o2) {
		return o1.v == o2.v;
	}

	@Override
	public Int64 getOne() {
		return valueOf(1);
	}

	@Override
	public boolean isOne(Int64 v) {
		return v.v == 1;
	}
	
	@Override
	public Int64 add(Int64 o1, Int64 o2) {
		return valueOf(GuavasLongMath.checkedAdd(o1.v, o2.v));
	}

	@Override
	public Int64 subtract(Int64 minuend, Int64 subtrahend) {
		return Int64.valueOf(GuavasLongMath.checkedSubtract(minuend.v, subtrahend.v));
	}

	@Override
	public Int64 multiply(Int64 v1, Int64 v2) {
		return Int64.valueOf(GuavasLongMath.checkedMultiply(v1.v, v2.v));
	}

	@Override
	public Int64 integerDivide(Int64 dividend, Int64 divisor) {
		return Int64.valueOf(dividend.v / divisor.v);
	}
	
	@Override
	public Int64 integerRemainder(Int64 dividend, Int64 divisor) {
		return Int64.valueOf(dividend.v % divisor.v);
	}

}
