package org.psjava.algo.sequence.sort;

import java.util.Comparator;

import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableSubArray;
import org.psjava.util.DefaultComparator;

public class SortingHelper {

    public static <T extends Comparable<T>> void sort(SortingAlgorithm sort, MutableArray<T> a) {
        sort.sort(a, new DefaultComparator<T>());
    }

    public static <T extends Comparable<T>> void sort(SortingAlgorithm sort, MutableArray<T> a, int start, int end) {
        sort.sort(MutableSubArray.wrap(a, start, end), new DefaultComparator<T>());
    }

    public static <T> void sort(SortingAlgorithm sort, MutableArray<T> a, int start, int end, Comparator<T> comparator) {
        sort.sort(MutableSubArray.wrap(a, start, end), comparator);
    }

    private SortingHelper() {
    }

}
