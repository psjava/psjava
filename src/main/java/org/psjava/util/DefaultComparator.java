package org.psjava.util;

import java.util.Comparator;

public class DefaultComparator<T extends Comparable<T>> implements Comparator<T> {
    public int compare(T arg0, T arg1) {
        return arg0.compareTo(arg1);
    }

}
