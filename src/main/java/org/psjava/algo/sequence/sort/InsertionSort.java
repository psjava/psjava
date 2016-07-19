package org.psjava.algo.sequence.sort;

import java.util.Comparator;

import org.psjava.ds.array.MutableArray;

public class InsertionSort {

    public static SortingAlgorithm getInstance() {
        return new SortingAlgorithm() {
            @Override
            public <T> void sort(MutableArray<T> a, Comparator<T> comparator) {
                for (int i = 1; i < a.size(); i++) {
                    T cur = a.get(i);
                    int p = i - 1;
                    while (p >= 0 && comparator.compare(cur, a.get(p)) < 0) {
                        a.set(p + 1, a.get(p));
                        p--;
                    }
                    a.set(p + 1, cur);
                }
            }
        };
    }

    private InsertionSort() {
    }

}