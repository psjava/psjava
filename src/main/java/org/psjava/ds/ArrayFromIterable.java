package org.psjava.ds;

import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.MutableArrayFromIterable;

public class ArrayFromIterable {

    public static <T> PSArray<T> create(Iterable<T> src) {
        return MutableArrayFromIterable.create(src);
    }

}
