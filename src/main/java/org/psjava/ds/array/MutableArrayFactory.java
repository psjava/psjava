package org.psjava.ds.array;

import org.psjava.util.ZeroTo;

public class MutableArrayFactory {
    public static <T> MutableArray<T> create(int size, T init) {
        @SuppressWarnings("unchecked")
        T[] a = (T[]) new Object[size];
        for (int i : ZeroTo.get(a.length))
            a[i] = init;
        return MutableArrayUsingJavaArray.wrap(a);
    }

    private MutableArrayFactory() {
    }
}
