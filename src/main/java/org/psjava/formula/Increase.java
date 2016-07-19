package org.psjava.formula;

import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;

public class Increase {

    public static <T> T calc(T v, IntegerDivisableNumberSystem<T> ns) {
        return ns.add(v, ns.getOne());
    }

    private Increase() {
    }

}
