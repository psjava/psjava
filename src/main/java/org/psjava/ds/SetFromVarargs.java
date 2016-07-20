package org.psjava.ds;

import org.psjava.util.VarargsIterable;

import java.util.Set;

public class SetFromVarargs {
    public static <T> Set<T> create(T... values) {
        return SetFromIterableV2.create(VarargsIterable.create(values));
    }
}
