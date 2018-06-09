package org.psjava.ds;

import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.ArrayIterator;
import org.psjava.util.GetterByIndex;
import org.psjava.util.IterableToString;

import java.util.Iterator;

// TODO to make code shorter, try to apply this to exist classes which implements Array
public class ArrayFromItemGetter {

    public static <T> PSArray<T> create(final int size, final GetterByIndex<T> getter) {
        return new PSArray<T>() {
            @Override
            public T get(int index) {
                return getter.get(index);
            }

            @Override
            public int size() {
                return size;
            }

            @Override
            public boolean isEmpty() {
                return size() == 0;
            }

            @Override
            public Iterator<T> iterator() {
                return ArrayIterator.create(this);
            }

            @Override
            public String toString() {
                return IterableToString.toString(this);
            }
        };
    }

}
