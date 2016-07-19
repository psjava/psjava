package org.psjava.util;

public class SizeOfIterable {

    public static <T> int getSize(Iterable<T> iterable) {
        int size = 0;
        for (T t : iterable)
            size++;
        return size;
    }

}
