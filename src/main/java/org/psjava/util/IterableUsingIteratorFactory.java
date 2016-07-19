package org.psjava.util;

import java.util.Iterator;

public class IterableUsingIteratorFactory {
    public static <T> Iterable<T> create(final IteratorFactory<T> factory) {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return factory.create();
            }

            @Override
            public String toString() {
                return IterableToString.toString(this);
            }
        };
    }
}
