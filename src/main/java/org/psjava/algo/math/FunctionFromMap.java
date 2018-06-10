package org.psjava.algo.math;

import org.psjava.ds.map.PSMap;

import java.util.function.Function;

public class FunctionFromMap {

    public static <I, O> Function<I, O> wrap(final PSMap<I, O> flow) {
        return new Function<I, O>() {
            @Override
            public O apply(I input) {
                return flow.get(input);
            }
        };
    }

    private FunctionFromMap() {
    }

}
