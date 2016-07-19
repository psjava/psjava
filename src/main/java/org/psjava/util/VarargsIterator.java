package org.psjava.util;

import java.util.Iterator;

import org.psjava.ds.array.ArrayFromVarargs;
import org.psjava.ds.array.ArrayIterator;

public class VarargsIterator {

    public static <T> Iterator<T> create(final T... data) {
        return ArrayIterator.create(ArrayFromVarargs.create(data));
    }

    private VarargsIterator() {
    }

}
