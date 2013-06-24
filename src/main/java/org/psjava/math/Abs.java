package org.psjava.math;

import org.psjava.math.ns.AddInvert;
import org.psjava.math.ns.AddableNumberSystem;


public class Abs {
	// TODO add unit test
	public static <T> T calc(AddableNumberSystem<T> ns, T v) {
		if (ns.isNegative(v))
			return AddInvert.calc(ns, v);
		return v;
	}
}
