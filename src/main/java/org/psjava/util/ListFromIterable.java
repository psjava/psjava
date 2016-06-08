package org.psjava.util;

import java.util.ArrayList;
import java.util.List;

public class ListFromIterable {

    public static <T> List<T> create(Iterable<T> items) {
        ArrayList<T> list = new ArrayList<T>();
        AddAll.add(list, items);
        return list;
    }

}
