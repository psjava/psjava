package org.psjava.algo.sort;

import junit.framework.Assert;


import org.junit.Test;
import org.psjava.TestUtil;
import org.psjava.ds.array.DynamicArray;


public class SortUtilTest {
	
	@Test
	public void test() {
		Sort s = new RandomizedQuickSort();
		DynamicArray<Integer> d = DynamicArray.create();
		for(int v : new int[] {4,3,1,2})
			d.addToLast(v);		
		SortUtil.sort(s, d, 1, 2);
		Assert.assertEquals(TestUtil.toArrayList(4,1,3,2), TestUtil.toArrayListFromIterable(d));
	}

}
