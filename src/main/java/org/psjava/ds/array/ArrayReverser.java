package org.psjava.ds.array;

public class ArrayReverser {

    public static <T> void reverse(MutableArray<T> a) {
        reverse(a, 0, a.size());
    }

    public static <T> void reverse(MutableArray<T> a, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++)
            ArraySwapper.swap(a, start + i, end - 1 - i);
    }

    private ArrayReverser() {
    }

}
