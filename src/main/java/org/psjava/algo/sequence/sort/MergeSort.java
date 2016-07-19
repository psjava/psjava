package org.psjava.algo.sequence.sort;

import java.util.Comparator;

import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFactory;

public class MergeSort {

    public static SortingAlgorithm getInstance() {
        return new SortingAlgorithm() {
            @Override
            public <T> void sort(MutableArray<T> a, Comparator<T> comparator) {
                MutableArray<T> temp = MutableArrayFactory.create(a.size(), null);
                sortRecursively(a, 0, a.size(), comparator, temp);
            }
        };
    }

    private static <T> void sortRecursively(MutableArray<T> array, int start, int end, Comparator<T> comparator, MutableArray<T> temp) {
        if (end - start <= 1)
            return;
        int mid = (start + end) / 2;
        sortRecursively(array, start, mid, comparator, temp);
        sortRecursively(array, mid, end, comparator, temp);

        int p = 0;
        int p1 = start;
        int p2 = mid;
        while (p1 < mid && p2 < end)
            if (comparator.compare(array.get(p1), array.get(p2)) < 0)
                temp.set(p++, array.get(p1++));
            else
                temp.set(p++, array.get(p2++));

        while (p1 < mid)
            temp.set(p++, array.get(p1++));
        while (p2 < end)
            temp.set(p++, array.get(p2++));
        for (int i = start; i < end; i++)
            array.set(i, temp.get(i - start));
    }

    private MergeSort() {
    }

}