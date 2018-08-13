package org.psjava.formula;

import java.util.function.BinaryOperator;

public class Accumulate {

    public static <T> T calc(Iterable<T> values, T init, BinaryOperator<T> op) {
        T r = init;
        for (T v : values)
            r = op.apply(r, v);
        return r;
    }

}
