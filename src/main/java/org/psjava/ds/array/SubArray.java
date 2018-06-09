package org.psjava.ds.array;

import org.psjava.ds.ArrayFromItemGetter;
import org.psjava.util.GetterByIndex;

public class SubArray {

    public static <T> PSArray<T> wrap(final PSArray<T> original, final int start, final int end) {
        return ArrayFromItemGetter.create(end - start, new GetterByIndex<T>() {
            @Override
            public T get(int index) {
                return original.get(start + index);
            }
        });
    }

    private SubArray() {
    }

}
