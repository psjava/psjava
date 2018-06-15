package org.psjava.ds.array;

import java.util.ArrayList;

public class AddToLastAll {

    @Deprecated
    public static <T> void add(DynamicArray<T> target, Iterable<? extends T> values) {
        for (T v : values)
            target.addToLast(v);
    }


    public static <T> void add(ArrayList<T> target, Iterable<? extends T> values) {
        for (T v : values)
            target.add(v);
    }

    private AddToLastAll() {
    }

}
