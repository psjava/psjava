package org.psjava.math;

import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class CeilDivide {
	public static <T> T calc(IntegerDivisableNumberSystem<T> ns, T dividend, T divisor) {
		return ns.integerDivide(ns.add(dividend, ns.subtract(divisor, ns.getOne())), divisor);
	}
}
