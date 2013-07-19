package org.psjava.algo.search;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.math.ns.JavaIntegerNumberSystem;


public class BinarySearchLastTrueTest {

	@Test
	public void test() {
		int index = BinarySearchLastTrue.search(JavaIntegerNumberSystem.getInstance(), -10000, 10000, new Function<Integer, Boolean>() {
			@Override
			public Boolean get(Integer index) {
				return index <= 400;
			}
		}, -1);
		Assert.assertEquals(400, index);
	}

}
