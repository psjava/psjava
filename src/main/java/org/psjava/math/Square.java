package org.psjava.math;

import org.psjava.math.ns.MultipliableNumberSystem;

public class Square {
	static public <T> T calc(MultipliableNumberSystem<T> ns, T v) {
		return ns.multiply(v, v);
	}
}
