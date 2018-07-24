package org.psjava.ds.array;

import org.psjava.ds.MutableArrayFromItemSetter;
import org.psjava.util.Assertion;
import org.psjava.util.GetterByIndex;
import org.psjava.util.SetterByIndex;

public class MutableSubArray {

    public static <T> MutableArray<T> wrap(final MutableArray<T> superArray, final int start, final int end) {
        final int size = end - start;
        return MutableArrayFromItemSetter.create(size, new GetterByIndex<T>() {
            @Override
            public T get(int index) {
                Assertion.ensure(0 <= index && index < size);
                return superArray.get(start + index);
            }

        }, new SetterByIndex<T>() {
            @Override
            public void set(int index, T value) {
                Assertion.ensure(0 <= index && index < size);
                superArray.set(start + index, value);
            }
        });
    }

    private MutableSubArray() {
    }
}
