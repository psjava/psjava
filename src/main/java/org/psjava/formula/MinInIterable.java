package org.psjava.formula;

import java.util.Comparator;

import org.psjava.util.ReversedComparator;

public class MinInIterable {

    public static <T> T min(Iterable<T> iterable, Comparator<T> comp) {
        return MaxInIterable.max(iterable, ReversedComparator.wrap(comp));
    }

    private MinInIterable() {
    }

}
