package org.psjava.ds.array;

import java.util.function.Function;

public class FunctionByArray {

    public static <T> Function<Integer, T> wrap(final PSArray<T> array) {
        return new Function<Integer, T>() {
            @Override
            public T apply(Integer input) {
                return array.get(input);
            }
        };
    }

    private FunctionByArray() {
    }

}
