package org.psjava.formula;

import java.util.Comparator;

import org.psjava.util.Assertion;

public class MaxInIterable {

    public static <T> T max(Iterable<T> iterable, Comparator<T> comp) {
        T max = null;
        for (T a : iterable)
            if (max == null || comp.compare(max, a) < 0)
                max = a;
        Assertion.ensure(max != null, "Empty Iterable");
        return max;
    }

    private MaxInIterable() {
    }

}
