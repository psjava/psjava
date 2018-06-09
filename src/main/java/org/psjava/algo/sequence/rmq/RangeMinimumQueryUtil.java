package org.psjava.algo.sequence.rmq;

import java.util.Comparator;

import org.psjava.ds.array.PSArray;

public class RangeMinimumQueryUtil {

    public static <T> int selectSmallestIndex(final PSArray<T> a, int i1, int i2, final Comparator<T> comp) {
        if (comp.compare(a.get(i1), a.get(i2)) < 0)
            return i1;
        else
            return i2;
    }

    private RangeMinimumQueryUtil() {
    }

}
