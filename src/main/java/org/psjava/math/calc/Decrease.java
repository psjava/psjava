package org.psjava.math.calc;

import org.psjava.math.ns.MultipliableNumberSystem;

public class Decrease {

	public static <T> T calc(MultipliableNumberSystem<T> ns, T endKey) {
		return ns.subtract(endKey, ns.getOne());
	}

}
