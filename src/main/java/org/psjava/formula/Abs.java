package org.psjava.formula;

import org.psjava.ds.numbersystrem.AddInvert;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class Abs {
	// TODO add unit test
	public static <T> T calc(AddableNumberSystem<T> ns, T v) {
		if (ns.isNegative(v))
			return AddInvert.calc(ns, v);
		return v;
	}
}
