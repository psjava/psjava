package org.psjava.algo.search;


import org.junit.Assert;
import org.junit.Test;
import org.psjava.math.Function;
import org.psjava.math.ns.IntegerNumberSystem;

public class BinarySearchFirstTrueTest {

	private static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

	@Test
	public void test() {
		int actual = BinarySearchFirstTrue.search(NS, new Function<Integer, Boolean>() {
			@Override
			public Boolean get(Integer index) {
				return index >= 100;
			}			
		}, -10000, 10000, -1);
		Assert.assertEquals(100, actual);
	}
	
}
