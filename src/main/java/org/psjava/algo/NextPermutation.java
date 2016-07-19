package org.psjava.algo;

import org.psjava.ds.array.ArrayReverser;
import org.psjava.ds.array.ArraySwapper;
import org.psjava.ds.array.MutableArray;

import java.util.Comparator;

public class NextPermutation {

    public static <T> boolean step(MutableArray<T> array, Comparator<T> comparator) {
        int p = -1;
        for (int i = array.size() - 2; i >= 0; i--)
            if (comparator.compare(array.get(i), array.get(i + 1)) < 0) {
                p = i;
                break;
            }

        if (p == -1)
            return false;

        ArrayReverser.reverse(array, p + 1, array.size());

        for (int i = p + 1; i < array.size(); i++)
            if (comparator.compare(array.get(i), array.get(p)) > 0) {
                ArraySwapper.swap(array, p, i);
                break;
            }
        return true;
    }

}