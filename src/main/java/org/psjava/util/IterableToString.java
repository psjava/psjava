package org.psjava.util;

public class IterableToString {
    public static <T> String toString(Iterable<T> iterable) {
        return IteratorToString.toString(iterable.iterator());
    }
}
