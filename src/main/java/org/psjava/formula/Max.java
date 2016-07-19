package org.psjava.formula;

import java.util.Comparator;

public class Max {

    public static <T> T max(T v1, T v2, Comparator<T> comp) {
        if (comp.compare(v1, v2) > 0)
            return v1;
        else
            return v2;
    }

    private Max() {
    }

}
