package org.psjava.ds.array;

import org.psjava.ds.ArrayFromItemGetter;
import org.psjava.util.GetterByIndex;

public class CharacterArrayUsingString {

    public static PSArray<Character> wrap(final String s) {
        return ArrayFromItemGetter.create(s.length(), new GetterByIndex<Character>() {
            @Override
            public Character get(int index) {
                return s.charAt(index);
            }
        });
    }

    private CharacterArrayUsingString() {
    }

}
