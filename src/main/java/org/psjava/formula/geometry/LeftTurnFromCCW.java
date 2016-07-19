package org.psjava.formula.geometry;

import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class LeftTurnFromCCW {

    public static <T> boolean is(AddableNumberSystem<T> ns, T ccw) {
        return ns.isPositive(ccw);
    }

    private LeftTurnFromCCW() {
    }

}
