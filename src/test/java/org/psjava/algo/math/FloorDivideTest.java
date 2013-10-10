package org.psjava.algo.math;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.math.FloorDivide;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;


public class FloorDivideTest {

	private static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

	@Test
	public void test() {
		Assert.assertEquals(1, (int) FloorDivide.calc(NS, 3, 2));
		Assert.assertEquals(1, (int) FloorDivide.calc(NS, -3, -2));
		Assert.assertEquals(-2, (int) FloorDivide.calc(NS, -3, 2));
		Assert.assertEquals(-2, (int) FloorDivide.calc(NS, 3, -2));
		Assert.assertEquals(-1, (int) FloorDivide.calc(NS, -1, 2));
		Assert.assertEquals(0, (int) FloorDivide.calc(NS, 1, 2));
	}
}
