package org.psjava.util;

import java.util.Comparator;

public class SeriesComparator<T> {

    public static <T> Comparator<T> create(final Comparator<T>... compList) {
        return new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                for (Comparator<T> comp : compList) {
                    int c = comp.compare(o1, o2);
                    if (c != 0)
                        return c;
                }
                return 0;
            }
        };
    }

    private SeriesComparator() {
    }

}
