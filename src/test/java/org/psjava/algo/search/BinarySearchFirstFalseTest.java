package org.psjava.algo.search;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.math.ns.IntegerNumberSystem;


public class BinarySearchFirstFalseTest {

	@Test
	public void test() {
		int index = BinarySearchFirstFalse.search(IntegerNumberSystem.getInstance(), -10000, 10000, new Function<Integer, Boolean>() {
			@Override
			public Boolean get(Integer index) {
				return index < 400;
			}
		}, -1);
		Assert.assertEquals(400, index);
	}

}
