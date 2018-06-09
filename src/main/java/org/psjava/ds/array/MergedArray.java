package org.psjava.ds.array;

import org.psjava.ds.ArrayFromItemGetter;
import org.psjava.util.GetterByIndex;

public class MergedArray {

    public static <T> PSArray<T> wrap(final PSArray<T> left, final PSArray<T> right) {
        return ArrayFromItemGetter.create(left.size() + right.size(), new GetterByIndex<T>() {
            @Override
            public T get(int index) {
                if (index < left.size())
                    return left.get(index);
                return right.get(index - left.size());
            }
        });
    }

    private MergedArray() {
    }

}
