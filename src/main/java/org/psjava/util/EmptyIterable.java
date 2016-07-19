package org.psjava.util;

import java.util.Iterator;

public class EmptyIterable<E> implements Iterable<E> {

    public static <E> Iterable<E> create() {
        return new EmptyIterable<E>();
    }

    @Override
    public Iterator<E> iterator() {
        return new ReadOnlyIterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                throw new RuntimeException();
            }
        };
    }

}
