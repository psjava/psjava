package org.psjava.util;

import java.util.Iterator;

import org.psjava.ds.PSCollection;

public class SingleElementCollection<T> {

    public static <T> PSCollection<T> create(final T value) {
        return new PSCollection<T>() {
            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Iterator<T> iterator() {
                return SingleElementIterator.create(value);
            }

            @Override
            public int size() {
                return 1;
            }
        };
    }

    private SingleElementCollection() {
    }
}
