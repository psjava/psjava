package org.psjava;

import org.psjava.ds.ListUsingGetter;

import java.util.List;

public class UniformList {

    public static <T> List<T> create(final T value, final int size) {
        return ListUsingGetter.wrap(size, i -> value);
    }

}
