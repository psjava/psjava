package org.psjava.formula.geometry;

import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class RightTurnFromCCW {

    public static <T> boolean is(AddableNumberSystem<T> ns, T ccw) {
        return ns.isNegative(ccw);
    }

    private RightTurnFromCCW() {
    }

}
