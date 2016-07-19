package org.psjava.ds.set;

public class InsertAllToSet {
    public static <T> void insertAll(MutableSet<T> set, Iterable<? extends T> values) {
        for (T v : values)
            set.addIfAbsent(v);
    }

    private InsertAllToSet() {
    }
}
