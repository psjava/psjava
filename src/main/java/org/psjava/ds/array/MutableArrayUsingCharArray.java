package org.psjava.ds.array;

import org.psjava.ds.MutableArrayFromItemSetter;
import org.psjava.util.GetterByIndex;
import org.psjava.util.SetterByIndex;

public class MutableArrayUsingCharArray {

    public static MutableArray<Character> wrap(final char[] array) {
        return MutableArrayFromItemSetter.create(array.length, new GetterByIndex<Character>() {
            @Override
            public Character get(int index) {
                return array[index];
            }
        }, new SetterByIndex<Character>() {
            @Override
            public void set(int index, Character value) {
                array[index] = value;
            }
        });
    }

    private MutableArrayUsingCharArray() {
    }

}
