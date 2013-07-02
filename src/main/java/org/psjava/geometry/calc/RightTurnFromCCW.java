package org.psjava.geometry.calc;

import org.psjava.math.ns.AddableNumberSystem;

public class RightTurnFromCCW {

	public static <T> boolean is(AddableNumberSystem<T> ns, T ccw) {
		return ns.isNegative(ccw);
	}


}
