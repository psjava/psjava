package org.psjava.ds;

import java.util.Set;

public class AddAllToSet {
    public static <T> void insertAll(Set<T> set, Iterable<? extends T> values) {
        for (T v : values)
            set.add(v);
    }
}
