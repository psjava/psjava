package org.psjava.util;

import java.util.Iterator;

public class ConvertedIterable {

    public static <T1, T2> Iterable<T2> create(final Iterable<T1> outerIterable, final Converter<T1, T2> converter) {
        return new Iterable<T2>() {
            @Override
            public Iterator<T2> iterator() {
                return ConvertedIterator.create(outerIterable.iterator(), converter);
            }

            @Override
            public String toString() {
                return IterableToString.toString(this);
            }
        };
    }

    private ConvertedIterable() {
    }
}