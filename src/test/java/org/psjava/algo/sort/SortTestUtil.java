package org.psjava.algo.sort;

import junit.framework.Assert;

import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.javautil.DefaultComparator;

public class SortTestUtil {

	public static void testSimpleSort(Sort sort) {
		MutableArray<Integer> a = MutableArrayFromValues.create(2, 3, 1);
		sort.sort(a, new DefaultComparator<Integer>());
		Assert.assertEquals(MutableArrayFromValues.create(1, 2, 3), a);
	}

}
