package org.psjava.ds.array;

import org.psjava.ds.ArrayFromItemGetter;
import org.psjava.util.GetterByIndex;

public class ReversedArray {

    public static <T> PSArray<T> wrap(final PSArray<T> original) {
        return ArrayFromItemGetter.create(original.size(), new GetterByIndex<T>() {
            @Override
            public T get(int index) {
                return original.get(original.size() - 1 - index);
            }
        });
    }

}
