package org.psjava.algo.sort;

import java.util.Comparator;

import org.psjava.ds.array.MutableArray;


public interface Sort {
	<T> void sort(MutableArray<T> a, Comparator<T> comparator);
}