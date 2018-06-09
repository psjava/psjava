package org.psjava.formula;

import org.psjava.ds.array.PSArray;
import org.psjava.util.ReversedComparator;

import java.util.Comparator;

public class MinIndexInArray {
    public static <T> int get(PSArray<T> c, Comparator<T> comp) {
        return MaxIndexInArray.get(c, ReversedComparator.wrap(comp));
    }
}
