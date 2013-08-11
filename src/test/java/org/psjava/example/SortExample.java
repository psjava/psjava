package org.psjava.example;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.sort.BubbleSort;
import org.psjava.algo.sort.InsertionSort;
import org.psjava.algo.sort.MergeSort;
import org.psjava.algo.sort.RandomizedQuickSort;
import org.psjava.algo.sort.SortHelper;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.goods.GoodSort;
import org.psjava.javautil.DefaultComparator;

public class SortExample {
	@Test
	public void example() {

		// Following example is normal usage.

		MutableArray<Integer> array1 = MutableArrayFromValues.create(2, 1, 3);
		GoodSort.getInstance().sort(array1, new DefaultComparator<Integer>());
		
		// The result is,
		Assert.assertEquals("(1,2,3)", array1.toString());
		
		
		// There is only one method in Sort interface,
		// but there are several convenient methods in SortHelper class
		// Let'ss do partial sort.
		
		MutableArray<Integer> array2 = MutableArrayFromValues.create(100, 3, 2, 1, 0);
		SortHelper.sort(GoodSort.getInstance(), array2, 1, 4);

		// The result is,
		Assert.assertEquals("(100,1,2,3,0)", array2.toString());

		
		// We recommend to use the good one. but you can use specify algorithm. check them!
		GoodSort.getInstance();
		RandomizedQuickSort.getInstance();
		InsertionSort.getInstance();
		BubbleSort.getInstance();
		MergeSort.getInstance();
	}
}
