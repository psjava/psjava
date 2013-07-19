package org.psjava.math.calc;

import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class Increase {

	public static <T> T calc(IntegerDivisableNumberSystem<T> ns, T v) {
		return ns.add(v, ns.getOne());
	}

}
