package org.psjava.math;

import org.psjava.javautil.VarargsIterable;
import org.psjava.math.ns.AddableNumberSystem;

public class SumVarargs {

	public static <T> T calc(AddableNumberSystem<T> ns, T... values) {
		return Sum.calc(ns, VarargsIterable.create(values));
	}

}
