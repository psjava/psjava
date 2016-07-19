package org.psjava.util;

import java.util.Iterator;

import org.psjava.ds.Collection;

public class MergedCollection {

    public static <T> Collection<T> wrap(final Iterable<? extends Collection<? extends T>> collections) {
        return new Collection<T>() {
            @Override
            public Iterator<T> iterator() {
                return MergedIterator.create(collections);
            }

            @Override
            public boolean isEmpty() {
                for (Collection<? extends T> c : collections)
                    if (!c.isEmpty())
                        return false;
                return true;
            }

            @Override
            public int size() {
                int sum = 0;
                for (Collection<? extends T> c : collections)
                    sum += c.size();
                return sum;
            }

            @Override
            public String toString() {
                return IterableToString.toString(this);
            }
        };
    }

    private MergedCollection() {
    }

}
