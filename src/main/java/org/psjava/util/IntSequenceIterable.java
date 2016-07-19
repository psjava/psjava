package org.psjava.util;

import java.util.Iterator;

public class IntSequenceIterable {
    public static Iterable<Integer> create(final int from, final int step, final int size) {
        return IterableUsingIteratorFactory.create(new IteratorFactory<Integer>() {
            @Override
            public Iterator<Integer> create() {
                return IntSequenceIterator.create(from, step, size);
            }
        });
    }

    private IntSequenceIterable() {
    }
}