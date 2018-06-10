package org.psjava.util;

import java.util.Iterator;

import org.psjava.ds.PSCollection;

public class MergedCollection {

    public static <T> PSCollection<T> wrap(final Iterable<? extends PSCollection<? extends T>> collections) {
        return new PSCollection<T>() {
            @Override
            public Iterator<T> iterator() {
                return MergedIterator.create(collections);
            }

            @Override
            public boolean isEmpty() {
                for (PSCollection<? extends T> c : collections)
                    if (!c.isEmpty())
                        return false;
                return true;
            }

            @Override
            public int size() {
                int sum = 0;
                for (PSCollection<? extends T> c : collections)
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
