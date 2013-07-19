package org.psjava.algo.search;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.math.ns.IntegerNumberSystem;


public class BinarySearchLastFalseTest {

	Function<Integer, Boolean> func = new Function<Integer, Boolean>() {
		@Override
		public Boolean get(Integer x) {
			return x >= 5;
		}
	};

	@Test
	public void testNormal() {
		int actual = BinarySearchLastFalse.search(IntegerNumberSystem.getInstance(), 0, 10, func, -1);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void testAllFalse() {
		int actual = BinarySearchLastFalse.search(IntegerNumberSystem.getInstance(), 0, 4, func, -1);
		Assert.assertEquals(3, actual);
	}

	@Test
	public void testAllTrue() {
		int actual = BinarySearchLastFalse.search(IntegerNumberSystem.getInstance(), 5, 10, func, -1);
		Assert.assertEquals(-1, actual);
	}

}
