package org.psjava.ds.numbersystrem;

public class AddInvert {

    public static <T> T calc(AddableNumberSystem<T> ns, T v) {
        return ns.subtract(ns.getZero(), v);
    }

    private AddInvert() {
    }

}
