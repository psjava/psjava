package org.psjava.algo.math;

import org.junit.Assert;
import org.junit.Test;

import org.psjava.algo.math.ArithmeticSeries;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;


public class ArithmeticSeriesTest {
	@Test
	public void test() {
		int actual = ArithmeticSeries.calc(IntegerNumberSystem.getInstance(), 3, 2, 4); // 3+5+7+9
		Assert.assertEquals(24, actual);
	}
}
