package org.psjava.ds;

import org.psjava.util.GetterByIndex;

import java.util.AbstractList;
import java.util.List;

public class ListUsingGetter {

    public static <T> List<T> wrap(final int size, final GetterByIndex<T> getterByIndex) {
        return new AbstractList<T>() {
            @Override
            public int size() {
                return size;
            }

            @Override
            public T get(int index) {
                return getterByIndex.get(index);
            }
        };
    }

}
