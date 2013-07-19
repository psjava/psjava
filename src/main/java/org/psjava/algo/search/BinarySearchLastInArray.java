package org.psjava.algo.search;

import java.util.Comparator;

import org.psjava.ds.array.Array;
import org.psjava.math.ns.IntegerNumberSystem;

public class BinarySearchLastInArray {

	public static <T> int search(final Array<T> array, final T target, final Comparator<T> sortedOrderComparator, int def) {
		int subr = BinarySearchLastTrue.search(IntegerNumberSystem.getInstance(), 0, array.size(), new Function<Integer, Boolean>() {
			@Override
			public Boolean get(Integer x) {
				return sortedOrderComparator.compare(array.get(x), target) <= 0;
			}
		}, def);
		if(subr != -1 && array.get(subr).equals(target))
			return subr;
		else
			return def;
	}

}
