package org.psjava.math.ns;

public class Int32NumberSystem implements IntegerDivisableNumberSystem<Int32> {

	@Override
	public Int32 getZero() {
		return Int32.valueOf(0);
	}

	@Override
	public boolean isPositive(Int32 v) {
		return v.v > 0;
	}

	@Override
	public boolean isZero(Int32 v) {
		return v.v == 0;
	}

	@Override
	public boolean isNegative(Int32 v) {
		return v.v < 0;
	}

	@Override
	public int getSign(Int32 v) {
		if (v.v > 0)
			return 1;
		else if (v.v < 0)
			return -1;
		else
			return 0;
	}
	
	@Override
	public boolean areEqual(Int32 o1, Int32 o2) {
		return o1.v == o2.v;
	}

	@Override
	public Int32 getOne() {
		return Int32.valueOf(1);
	}

	@Override
	public boolean isOne(Int32 v) {
		return v.v == 1;
	}
	
	@Override
	public Int32 add(Int32 v1, Int32 v2) {
		long res = (long)v1.v + (long)v2.v;
		return safeCastFromLong(res);
	}

	@Override
	public Int32 subtract(Int32 minuend, Int32 subtrahend) {
		long res = (long)minuend.v - (long)subtrahend.v;
		return safeCastFromLong(res);
	}

	@Override
	public Int32 multiply(Int32 v1, Int32 v2) {
		long r = (long)v1.v * (long)v2.v;
		return safeCastFromLong(r);
	}

	@Override
	public Int32 integerDivide(Int32 dividend, Int32 divisor) {
		return Int32.valueOf(dividend.v / divisor.v);
	}
	
	@Override
	public Int32 integerRemainder(Int32 dividend, Int32 divisor) {
		return Int32.valueOf(dividend.v % divisor.v);
	}

	private Int32 safeCastFromLong(long v) {
		if(v != (int)v)
			throw OverflowException.create();
		return Int32.valueOf((int)v);
	}

	@Override
	public int compare(Int32 o1, Int32 o2) {
		if (o1.v > o2.v)
			return 1;
		else if (o1.v < o2.v)
			return -1;
		else
			return 0;
	}

}
