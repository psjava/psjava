package org.psjava.util;

import java.util.Iterator;

public class MergedIterator {

    public static <T> Iterator<T> create(final Iterable<? extends Iterable<? extends T>> iterables) {
        return new ReadOnlyIterator<T>() {
            Iterator<? extends Iterable<? extends T>> topIterator = iterables.iterator();
            Iterator<? extends T> currentSubIterator = null;

            @Override
            public boolean hasNext() {
                while (currentSubIterator == null || !currentSubIterator.hasNext()) {
                    if (topIterator.hasNext())
                        currentSubIterator = topIterator.next().iterator();
                    else
                        return false;
                }
                return true;
            }

            @Override
            public T next() {
                hasNext();
                return currentSubIterator.next();
            }
        };
    }

    private MergedIterator() {
    }

}
