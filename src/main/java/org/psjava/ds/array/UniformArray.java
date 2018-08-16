package org.psjava.ds.array;

import org.psjava.ds.ArrayFromItemGetter;
import org.psjava.util.GetterByIndex;

// TODO use UniformList
@Deprecated
public class UniformArray {

    public static <T> PSArray<T> create(final T value, final int size) {
        return ArrayFromItemGetter.create(size, new GetterByIndex<T>() {
            @Override
            public T get(int index) {
                return value;
            }
        });
    }

    private UniformArray() {
    }

}
