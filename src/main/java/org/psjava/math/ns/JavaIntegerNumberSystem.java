package org.psjava.math.ns;

public class JavaIntegerNumberSystem implements IntegerDivisableNumberSystem<Integer> {

	public static final JavaIntegerNumberSystem INSTANCE = new JavaIntegerNumberSystem();

	public static JavaIntegerNumberSystem getInstance() {
		return INSTANCE;
	}

	private JavaIntegerNumberSystem() {
	}

	@Override
	public Integer getZero() {
		return 0;
	}

	@Override
	public boolean isPositive(Integer v) {
		return v > 0;
	}

	@Override
	public boolean isZero(Integer v) {
		return v == 0;
	}

	@Override
	public boolean isNegative(Integer v) {
		return v < 0;
	}

	@Override
	public int getSign(Integer v) {
		if (v > 0)
			return 1;
		else if (v < 0)
			return -1;
		else
			return 0;
	}
	
	@Override
	public boolean areEqual(Integer o1, Integer o2) {
		return o1 == o2;
	}

	@Override
	public Integer getOne() {
		return Integer.valueOf(1);
	}

	@Override
	public boolean isOne(Integer v) {
		return v == 1;
	}
	
	@Override
	public Integer add(Integer v1, Integer v2) {
		long res = (long) v1 + (long) v2;
		return safeCastFromLong(res);
	}

	@Override
	public Integer subtract(Integer minuend, Integer subtrahend) {
		long res = (long) minuend - (long) subtrahend;
		return safeCastFromLong(res);
	}

	@Override
	public Integer multiply(Integer v1, Integer v2) {
		long r = (long) v1 * (long) v2;
		return safeCastFromLong(r);
	}

	@Override
	public Integer integerDivide(Integer dividend, Integer divisor) {
		return Integer.valueOf(dividend / divisor);
	}
	
	@Override
	public Integer integerRemainder(Integer dividend, Integer divisor) {
		return Integer.valueOf(dividend % divisor);
	}

	private Integer safeCastFromLong(long v) {
		if(v != (int)v)
			throw OverflowException.create();
		return Integer.valueOf((int) v);
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 > o2)
			return 1;
		else if (o1 < o2)
			return -1;
		else
			return 0;
	}

}
