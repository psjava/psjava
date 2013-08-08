package org.psjava.math;

public class Power {

	public static <T> T calc(T value, int n, BinaryOperator<T> operator) {
		if (n == 1) {
			return value;
		} else {
			T sub = calc(value, n / 2, operator);
			T r = operator.calc(sub, sub);
			if (n % 2 == 1)
				r = operator.calc(r, value);
			return r;
		}
	}

}
