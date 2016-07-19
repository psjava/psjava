package org.psjava.formula;

import java.util.Comparator;

import org.psjava.util.VarargsIterable;

public class MaxInVarargs {

    public static <T> T max(Comparator<T> comp, T... values) {
        return MaxInIterable.max(VarargsIterable.create(values), comp);
    }

    private MaxInVarargs() {
    }

}
