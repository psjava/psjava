package org.psjava.algo.sequence.sort;

import java.util.Comparator;

import org.psjava.ds.array.MutableArray;

public interface SortingAlgorithm {
    <T> void sort(MutableArray<T> a, Comparator<T> comparator);
}