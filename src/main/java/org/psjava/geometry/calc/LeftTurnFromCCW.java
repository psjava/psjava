package org.psjava.geometry.calc;

import org.psjava.math.ns.AddableNumberSystem;

public class LeftTurnFromCCW {

	public static <T> boolean is(AddableNumberSystem<T> ns, T ccw) {
		return ns.isPositive(ccw);
	}

}
