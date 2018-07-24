package org.psjava.util;

import java.util.Iterator;

public class SingleElementIterator {

    public static <T> Iterator<T> create(final T value) {
        return new ReadOnlyIterator<T>() {
            boolean read = false;

            @Override
            public boolean hasNext() {
                return !read;
            }

            @Override
            public T next() {
                Assertion.ensure(!read, "no item anymore");
                read = true;
                return value;
            }
        };
    }

    private SingleElementIterator() {
    }

}
