package org.psjava.formula;

import java.util.Comparator;

import org.psjava.ds.array.PSArray;
import org.psjava.util.Assertion;
import org.psjava.util.ZeroTo;

public class MaxIndexInArray {

    public static <T> int get(PSArray<T> a, Comparator<T> comp) {
        int r = -1;
        for (int i : ZeroTo.get(a.size()))
            if (r == -1 || comp.compare(a.get(r), a.get(i)) < 0)
                r = i;
        Assertion.ensure(r != -1, "Empty Iterable");
        return r;
    }

}
