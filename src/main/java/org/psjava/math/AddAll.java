package org.psjava.math;

import org.psjava.math.ns.AddableNumberSystem;

public class AddAll {

	public static <T> T add(AddableNumberSystem<T> ns, T value, T... values) {
		T r = value;
		for (T v : values)
			r = ns.add(r, v);
		return r;
	}

}
