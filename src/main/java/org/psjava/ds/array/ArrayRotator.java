package org.psjava.ds.array;

public class ArrayRotator {

    public static <T> void rotate(MutableArray<T> a, int leftShiftCount) {
        ArrayReverser.reverse(a, 0, leftShiftCount);
        ArrayReverser.reverse(a, leftShiftCount, a.size());
        ArrayReverser.reverse(a, 0, a.size());
    }

    private ArrayRotator() {
    }
}
