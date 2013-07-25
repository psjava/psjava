package org.psjava.algo.sort;

import java.util.Comparator;

import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableSubArray;
import org.psjava.javautil.DefaultComparator;

public class SortHelper {

	public static <T extends Comparable<T>> void sort(Sort sort, MutableArray<T> a) {
		sort.sort(MutableSubArray.wrap(a, 0, a.size()), new DefaultComparator<T>());
	}

	public static <T extends Comparable<T>> void sort(Sort sort, MutableArray<T> a, int start, int size) {
		sort.sort(MutableSubArray.wrap(a, start, size), new DefaultComparator<T>());
	}
	
	public static <T> void sort(Sort sort, MutableArray<T> a, int start, int size, Comparator<T> comparator) {
		sort.sort(MutableSubArray.wrap(a, start, size), comparator);
	}
	
}
