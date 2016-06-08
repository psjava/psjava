package org.psjava.ds;

import org.psjava.util.GetterByIndex;

import java.util.List;

public class ListUsingString {

    public static List<Character> wrap(final String s) {
        return ListUsingGetter.wrap(s.length(), new GetterByIndex<Character>() {
            @Override
            public Character get(int index) {
                return s.charAt(index);
            }
        });
    }

}
