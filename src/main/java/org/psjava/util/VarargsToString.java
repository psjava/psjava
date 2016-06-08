package org.psjava.util;

public class VarargsToString {

    public static String toString(Object... items) {
        return VarargsIterable.create(items).toString();
    }

}
