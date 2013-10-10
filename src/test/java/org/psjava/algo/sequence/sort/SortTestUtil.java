package org.psjava.algo.sequence.sort;

import junit.framework.Assert;

import org.psjava.algo.sequence.sort.Sort;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.util.DefaultComparator;

public class SortTestUtil {

	public static void testSimpleSort(Sort sort) {
		MutableArray<Integer> a = MutableArrayFromValues.create(2, 3, 1);
		sort.sort(a, new DefaultComparator<Integer>());
		Assert.assertEquals(MutableArrayFromValues.create(1, 2, 3), a);
	}

}
