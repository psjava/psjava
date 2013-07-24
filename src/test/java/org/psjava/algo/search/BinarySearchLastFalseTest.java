package org.psjava.algo.search;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.math.ns.IntegerNumberSystem;


public class BinarySearchLastFalseTest {

	@Test
	public void testNormal() {
		int actual = BinarySearchLastFalse.search(IntegerNumberSystem.getInstance(), new Function<Integer, Boolean>() {
			@Override
			public Boolean get(Integer x) {
				return x >= 5;
			}
		}, 0, 10, -1);
		Assert.assertEquals(4, actual);
	}

}
