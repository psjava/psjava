package org.psjava.ds.array;

import org.psjava.ds.MutableArrayFromItemSetter;
import org.psjava.util.GetterByIndex;
import org.psjava.util.SetterByIndex;

public class MutableArrayUsingJavaArray {

    public static <T> MutableArray<T> wrap(final T[] array) {
        return MutableArrayFromItemSetter.create(array.length, new GetterByIndex<T>() {
            @Override
            public T get(int index) {
                return array[index];
            }
        }, new SetterByIndex<T>() {
            @Override
            public void set(int index, T value) {
                array[index] = value;
            }
        });
    }

    private MutableArrayUsingJavaArray() {
    }

}
