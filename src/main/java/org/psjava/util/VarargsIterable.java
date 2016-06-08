package org.psjava.util;

import java.util.Iterator;

public class VarargsIterable {

    public static <T> Iterable<T> create(final T... data) {
        return IterableUsingIteratorFactory.create(new IteratorFactory<T>() {
            @Override
            public Iterator<T> create() {
                return VarargsIterator.create(data);
            }
        });
    }

    private VarargsIterable() {
    }

}
