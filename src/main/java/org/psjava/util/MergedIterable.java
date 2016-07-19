package org.psjava.util;

import java.util.Iterator;

public class MergedIterable<T> {

    public static <T> Iterable<T> wrap(final Iterable<? extends Iterable<? extends T>> iterables) {
        return IterableUsingIteratorFactory.create(new IteratorFactory<T>() {
            @Override
            public Iterator<T> create() {
                return MergedIterator.create(iterables);
            }
        });
    }

    private MergedIterable() {
    }

}
