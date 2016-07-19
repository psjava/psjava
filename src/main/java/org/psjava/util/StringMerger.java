package org.psjava.util;

public class StringMerger {

    public static String merge(Iterable<? extends Object> strings, String spliter) {
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for (Object s : strings) {
            if (first)
                first = false;
            else
                sb.append(spliter);
            sb.append(s);
        }
        return sb.toString();
    }

    private StringMerger() {
    }

}
