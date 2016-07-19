package org.psjava.ds.array;

public class ArraySwapper {

    public static <T> void swap(MutableArray<T> a, int p1, int p2) {
        T t = a.get(p1);
        a.set(p1, a.get(p2));
        a.set(p2, t);
    }

    private ArraySwapper() {
    }
}
