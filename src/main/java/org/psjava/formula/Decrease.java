package org.psjava.formula;

import org.psjava.ds.numbersystrem.MultipliableNumberSystem;

public class Decrease {

	public static <T> T calc(MultipliableNumberSystem<T> ns, T endKey) {
		return ns.subtract(endKey, ns.getOne());
	}

}
