package org.psjava.algo.sort;

import java.util.Comparator;

import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableSubArray;
import org.psjava.javautil.DefaultComparator;

public class SortHelper {

	public static <T extends Comparable<T>> void sort(Sort sort, MutableArray<T> a) {
		sort.sort(a, new DefaultComparator<T>());
	}

	public static <T extends Comparable<T>> void sort(Sort sort, MutableArray<T> a, int start, int end) {
		sort.sort(MutableSubArray.wrap(a, start, end), new DefaultComparator<T>());
	}
	
	public static <T> void sort(Sort sort, MutableArray<T> a, int start, int end, Comparator<T> comparator) {
		sort.sort(MutableSubArray.wrap(a, start, end), comparator);
	}
	
}
