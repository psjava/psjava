package org.psjava.ds.array;

public class ArrayFromVarargs {
    public static <T> PSArray<T> create(T... values) {
        return MutableArrayFromVarargs.create(values);
    }

    private ArrayFromVarargs() {
    }
}
