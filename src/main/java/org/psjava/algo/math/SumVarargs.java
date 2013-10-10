package org.psjava.algo.math;

import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.util.VarargsIterable;

public class SumVarargs {

	public static <T> T calc(AddableNumberSystem<T> ns, T... values) {
		return Sum.calc(ns, VarargsIterable.create(values));
	}

}
