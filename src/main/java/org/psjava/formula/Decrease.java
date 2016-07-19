package org.psjava.formula;

import org.psjava.ds.numbersystrem.MultipliableNumberSystem;

public class Decrease {

    public static <T> T calc(T value, MultipliableNumberSystem<T> ns) {
        return ns.subtract(value, ns.getOne());
    }

    private Decrease() {
    }

}
