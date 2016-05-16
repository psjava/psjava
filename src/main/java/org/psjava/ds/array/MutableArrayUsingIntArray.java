package org.psjava.ds.array;

import org.psjava.ds.MutableArrayFromItemSetter;
import org.psjava.util.GetterByIndex;
import org.psjava.util.SetterByIndex;

public class MutableArrayUsingIntArray {

    public static MutableArray<Integer> wrap(final int[] array) {
        return MutableArrayFromItemSetter.create(array.length, new GetterByIndex<Integer>() {
            @Override
            public Integer get(int index) {
                return array[index];
            }
        }, new SetterByIndex<Integer>() {
            @Override
            public void set(int index, Integer value) {
                array[index] = value;
            }
        });
    }

    private MutableArrayUsingIntArray() {
    }

}
