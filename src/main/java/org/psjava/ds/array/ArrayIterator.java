package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.util.ReadOnlyIterator;

public class ArrayIterator {
    public static <T> Iterator<T> create(final PSArray<T> a) {
        return new ReadOnlyIterator<T>() {
            int p = 0;

            public boolean hasNext() {
                return p < a.size();
            }

            public T next() {
                return a.get(p++);
            }
        };
    }

    private ArrayIterator() {
    }
}
