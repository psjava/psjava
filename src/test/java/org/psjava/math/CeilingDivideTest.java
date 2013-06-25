package org.psjava.math;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.math.ns.Int64;
import org.psjava.math.ns.Int64System;


public class CeilingDivideTest {

	private static final Int64System NS = new Int64System();

	@Test
	public void testPositive() {
		Assert.assertEquals(4, CeilingDivide.calc(NS, tov(10), tov(3)).toPrimitive());
	}

	@Test(expected = ArithmeticException.class)
	public void testNegative() {
		CeilingDivide.calc(NS, tov(-10), tov(3));
	}

	private Int64 tov(int v) {
		return Int64.valueOf(v);
	}

}
