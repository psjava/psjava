package org.psjava.ds;

import org.psjava.ds.array.Array;
import org.psjava.ds.array.MutableArrayFromIterable;

public class ArrayFromIterable {

    public static <T> Array<T> create(Iterable<T> src) {
        return MutableArrayFromIterable.create(src);
    }

}
