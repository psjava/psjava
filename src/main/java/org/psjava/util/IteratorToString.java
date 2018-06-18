package org.psjava.util;

import java.util.Iterator;

public class IteratorToString {
    public static <T> String toString(Iterator<T> iter) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        while (iter.hasNext()) {
            T v = iter.next();
            sb.append(v);
            if (iter.hasNext())
                sb.append(',');
        }
        sb.append(')');
        return sb.toString();
    }
}
