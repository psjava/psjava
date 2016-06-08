package org.psjava.ds;

import org.psjava.util.GetterByIndex;

import java.util.List;

public class ListUsingCharArray {

    public static List<Character> wrap(final char... items) {
        return ListUsingGetter.wrap(items.length, new GetterByIndex<Character>() {
            @Override
            public Character get(int index) {
                return items[index];
            }
        });
    }
}
