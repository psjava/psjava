package org.psjava.ds.array;

public class MutableArrayFromIterable {
    public static <T> MutableArray<T> create(Iterable<T> src) {
        DynamicArray<T> res = DynamicArray.create();
        AddToLastAll.add(res, src);
        return res;
    }

    private MutableArrayFromIterable() {
    }
}
