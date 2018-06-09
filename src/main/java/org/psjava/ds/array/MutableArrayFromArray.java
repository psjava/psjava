package org.psjava.ds.array;

import org.psjava.util.ZeroTo;

public class MutableArrayFromArray {
    public static <T> MutableArray<T> create(PSArray<T> src) {
        MutableArray<T> res = MutableArrayFactory.create(src.size(), null);
        for (int i : ZeroTo.get(src.size()))
            res.set(i, src.get(i));
        return res;
    }

    private MutableArrayFromArray() {
    }
}
