package org.psjava.algo.sequence.search;

import org.psjava.ds.array.PSArray;

public class LinearSearch {

    public static <T> int search(PSArray<T> array, T value, int def) {
        for (int i = 0; i < array.size(); i++)
            if (array.get(i).equals(value))
                return i;
        return def;
    }

    private LinearSearch() {
    }

}
