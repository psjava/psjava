package org.psjava.formula;

import org.psjava.ds.numbersystrem.MultipliableNumberSystem;

public class Square {
    static public <T> T calc(MultipliableNumberSystem<T> ns, T v) {
        return ns.multiply(v, v);
    }

    private Square() {
    }
}
