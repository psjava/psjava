package org.psjava.ds.array;


import org.junit.Assert;
import org.junit.Test;
import org.psjava.TestUtil;


public class MutableSubArrayTest {
	@Test
	public void test() {
		DynamicArray<Integer> a = DynamicArray.create();
		AddToLastAll.add(a, TestUtil.toArrayList(1, 2, 3, 4));
		MutableArray<Integer> sub = MutableSubArray.create(a, 1, 2);
		Assert.assertEquals(TestUtil.toArrayList(2,3), TestUtil.toArrayListFromIterable(sub));
		sub.set(1, 100);
		Assert.assertEquals(TestUtil.toArrayList(1,2,100,4), TestUtil.toArrayListFromIterable(a));
	}
}
