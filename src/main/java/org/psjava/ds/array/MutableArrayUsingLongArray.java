package org.psjava.ds.array;

import org.psjava.ds.MutableArrayFromItemSetter;
import org.psjava.util.GetterByIndex;
import org.psjava.util.SetterByIndex;

public class MutableArrayUsingLongArray {

    public static MutableArray<Long> wrap(final long[] array) {
        return MutableArrayFromItemSetter.create(array.length, new GetterByIndex<Long>() {
            @Override
            public Long get(int index) {
                return array[index];
            }
        }, new SetterByIndex<Long>() {
            @Override
            public void set(int index, Long value) {
                array[index] = value;
            }
        });
    }

    private MutableArrayUsingLongArray() {
    }

}
