package org.psjava.ds.set;

public class MakeSetAll {

    public static <T> void make(DisjointSet<T> dset, Iterable<T> values) {
        for (T v : values) {
            dset.makeSet(v);
        }
    }

    private MakeSetAll() {
    }
}
