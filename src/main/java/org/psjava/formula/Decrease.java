package org.psjava.formula;

import org.psjava.ds.numbersystrem.MultipliableNumberSystem;

public class Decrease {

	public static <T> T calc(MultipliableNumberSystem<T> ns, T value) {
		return ns.subtract(value, ns.getOne());
	}

	private Decrease() {
	}

}
