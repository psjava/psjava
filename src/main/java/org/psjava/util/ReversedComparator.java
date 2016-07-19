package org.psjava.util;

import java.util.Comparator;

public class ReversedComparator {

    public static <T> Comparator<T> wrap(final Comparator<T> original) {
        return new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return original.compare(o2, o1);
            }
        };
    }

    private ReversedComparator() {
    }
}
