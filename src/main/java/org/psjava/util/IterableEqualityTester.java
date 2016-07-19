package org.psjava.util;

import java.util.Iterator;

public class IterableEqualityTester {

    public static <T> boolean areEqual(Iterable<T> o1, Iterable<T> o2) {
        Iterator<T> iter1 = o1.iterator();
        Iterator<T> iter2 = o2.iterator();
        while (true) {
            if (iter1.hasNext() != iter2.hasNext())
                return false;
            if (!iter1.hasNext())
                return true;
            T v1 = iter1.next();
            T v2 = iter2.next();
            if (!v1.equals(v2))
                return false;
        }
    }

    private IterableEqualityTester() {
    }

}
