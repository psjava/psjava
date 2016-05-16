package org.psjava.ds.array;

import org.psjava.ds.MutableArrayFromItemSetter;
import org.psjava.util.GetterByIndex;
import org.psjava.util.SetterByIndex;

public class MutableArrayUsingBooleanArray {

    public static MutableArray<Boolean> wrap(final boolean[] array) {
        return MutableArrayFromItemSetter.create(array.length, new GetterByIndex<Boolean>() {
            @Override
            public Boolean get(int index) {
                return array[index];
            }
        }, new SetterByIndex<Boolean>() {
            @Override
            public void set(int index, Boolean value) {
                array[index] = value;
            }
        });
    }

    private MutableArrayUsingBooleanArray() {
    }

}
