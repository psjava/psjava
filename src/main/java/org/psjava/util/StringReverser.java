package org.psjava.util;

import org.psjava.ds.array.ArrayReverser;
import org.psjava.ds.array.MutableArrayUsingCharArray;

public class StringReverser {

    public static String getReversed(String a) {
        char[] temp = a.toCharArray();
        ArrayReverser.reverse(MutableArrayUsingCharArray.wrap(temp));
        return new String(temp);
    }

    private StringReverser() {
    }
}
