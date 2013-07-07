package org.psjava.math;

import org.psjava.javautil.ArrayIterable;
import org.psjava.math.ns.AddableNumberSystem;

public class AddAll { // TODO rename to SumUtil

	// TODO rename to calc
	public static <T> T add(AddableNumberSystem<T> ns, T... values) {
		return Sum.calc(ns, ArrayIterable.create(values));
	}

}
