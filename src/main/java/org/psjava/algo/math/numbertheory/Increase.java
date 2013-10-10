package org.psjava.algo.math.numbertheory;

import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;

public class Increase {

	public static <T> T calc(IntegerDivisableNumberSystem<T> ns, T v) {
		return ns.add(v, ns.getOne());
	}

}
