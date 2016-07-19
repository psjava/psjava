package org.psjava.algo.math;

import org.psjava.ds.map.Map;
import org.psjava.ds.math.Function;

public class FunctionFromMap {

    public static <I, O> Function<I, O> wrap(final Map<I, O> flow) {
        return new Function<I, O>() {
            @Override
            public O get(I input) {
                return flow.get(input);
            }
        };
    }

    private FunctionFromMap() {
    }

}
