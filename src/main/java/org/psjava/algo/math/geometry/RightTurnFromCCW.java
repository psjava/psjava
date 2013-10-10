package org.psjava.algo.math.geometry;

import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class RightTurnFromCCW {

	public static <T> boolean is(AddableNumberSystem<T> ns, T ccw) {
		return ns.isNegative(ccw);
	}


}
