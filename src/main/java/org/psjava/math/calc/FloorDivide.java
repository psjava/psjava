package org.psjava.math.calc;

import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class FloorDivide {

	public static <T> T calc(IntegerDivisableNumberSystem<T> ns, T dividend, T divisor) {
		T div = ns.integerDivide(dividend, divisor);
		if (!ns.isNegative(div) || ns.isZero(ns.integerRemainder(dividend, divisor)))
			return div;
		else
			return ns.subtract(div, ns.getOne());
	}

}
