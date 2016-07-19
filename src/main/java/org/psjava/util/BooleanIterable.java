package org.psjava.util;

import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromVarargs;

public class BooleanIterable {

    private static final MutableArray<Boolean> INSTANCE = MutableArrayFromVarargs.create(Boolean.FALSE, Boolean.TRUE);

    public static Iterable<Boolean> getInstance() {
        return INSTANCE;
    }

    private BooleanIterable() {
    }

}
