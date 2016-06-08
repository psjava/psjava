package org.psjava.util;

import java.util.ArrayList;

public class AddAll {

    public static <T> void add(ArrayList<T> list, Iterable<T> items) {
        for (T item : items)
            list.add(item);
    }
}
