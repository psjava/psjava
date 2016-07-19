package org.psjava.ds;

import java.util.HashSet;
import java.util.Set;

public class SetFromIterableV2 {
    public static <T> Set<T> create(Iterable<T> iterable) {
        HashSet<T> r = new HashSet<T>();
        AddAllToSet.insertAll(r, iterable);
        return r;
    }
}
