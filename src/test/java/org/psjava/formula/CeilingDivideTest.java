package org.psjava.formula;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.Int64;
import org.psjava.ds.numbersystrem.Int64NumberSystem;
import org.psjava.formula.CeilingDivide;

public class CeilingDivideTest {

	private static final Int64NumberSystem NS = new Int64NumberSystem();

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
