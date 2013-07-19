package org.psjava.math.calc;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.math.ns.IntegerNumberSystem;


public class ArithmeticSeriesTest {
	@Test
	public void test() {
		int actual = ArithmeticSeries.calc(IntegerNumberSystem.getInstance(), 3, 2, 4); // 3+5+7+9
		Assert.assertEquals(24, actual);
	}
}
