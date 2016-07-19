package org.psjava.formula;

import java.util.Comparator;

public class InRange {

    public static <T> boolean is(T v, T lower, T upper, Comparator<T> comp) {
        return comp.compare(lower, v) <= 0 && comp.compare(v, upper) <= 0;
    }

    private InRange() {
    }

}
