package org.psjava.util;

import java.util.Iterator;

public class FilteredIterator {

    public static <T> Iterator<T> create(final Iterator<? extends T> a, final Filter<T> filter) {
        return new ReadOnlyIterator<T>() {
            T next = null;
            Iterator<? extends T> cursor = a;

            @Override
            public boolean hasNext() {
                tryToStepNext();
                return next != null;
            }

            @Override
            public T next() {
                tryToStepNext();
                T r = next;
                next = null;
                return r;
            }

            private void tryToStepNext() {
                while (next == null && cursor.hasNext()) {
                    T value = cursor.next();
                    if (filter.isAccepted(value))
                        next = value;
                }
            }

        };
    }

    private FilteredIterator() {
    }

}