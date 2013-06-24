package org.psjava.math.ns;

public class AddInvert {

	public static <T> T calc(AddableNumberSystem<T> ns, T v) {
		return ns.subtract(ns.getZero(), v);
	}

}
