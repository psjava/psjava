package org.psjava.algo.search;


import org.junit.Assert;
import org.junit.Test;
import org.psjava.math.ns.JavaIntegerNumberSystem;

public class BinarySearchFirstTrueTest {

	private static final JavaIntegerNumberSystem NS = JavaIntegerNumberSystem.getInstance();

	@Test
	public void test() {
		int actual = BinarySearchFirstTrue.search(NS, -10000, 10000, new Function<Integer, Boolean>() {
			@Override
			public Boolean get(Integer index) {
				return index >= 100;
			}			
		}, null);
		Assert.assertEquals(100, actual);
	}
	
	@Test
	public void testNagativeCase() {
		int actual = BinarySearchFirstTrue.search(NS, -10000, 10000, new Function<Integer, Boolean>() {
			@Override
			public Boolean get(Integer index) {
				return index >= -1000;
			}			
		}, null);
		Assert.assertEquals(-1000, actual);
	}
	
	@Test
	public void testNotFoundCase() {
		Integer actual = BinarySearchFirstTrue.search(NS, -10, 10, new Function<Integer, Boolean>() {
			@Override
			public Boolean get(Integer index) {
				return false;
			}			
		}, null);
		Assert.assertNull(actual);
	}
	
}
