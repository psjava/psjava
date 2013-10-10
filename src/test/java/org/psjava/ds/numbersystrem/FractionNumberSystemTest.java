package org.psjava.ds.numbersystrem;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.Fraction;
import org.psjava.ds.numbersystrem.FractionNumberSystem;
import org.psjava.ds.numbersystrem.Int32;
import org.psjava.ds.numbersystrem.Int32NumberSystem;

public class FractionNumberSystemTest {

	private static final FractionNumberSystem<Int32> NS = new FractionNumberSystem<Int32>(new Int32NumberSystem());

	@Test
	public void testBasicMath() {
		Fraction<Int32> add = NS.add(toFrac(12, 8), toFrac(3, 7));
		Assert.assertEquals(27, add.numerator.v);
		Assert.assertEquals(14, add.denominator.v);
		
		Fraction<Int32> sub = NS.subtract(toFrac(3, 7), toFrac(12, 8));
		Assert.assertEquals(-15, sub.numerator.v);
		Assert.assertEquals(14, sub.denominator.v);

		Fraction<Int32> mul = NS.multiply(toFrac(3, 7), toFrac(12, 8));
		Assert.assertEquals(9, mul.numerator.v);
		Assert.assertEquals(14, mul.denominator.v);

		Fraction<Int32> div = NS.divide(toFrac(6, 2), toFrac(3, 2));
		Assert.assertEquals(2, div.numerator.v);
		Assert.assertEquals(1, div.denominator.v);
	}

	@Test
	public void testAreEqual() {
		Assert.assertTrue(NS.areEqual(toFrac(2, 4), toFrac(1, 2)));
		Assert.assertFalse(NS.areEqual(toFrac(3, 4), toFrac(1, 2)));
	}

	@Test
	public void testGetSign() {
		Assert.assertEquals(1, NS.getSign(toFrac(2, 3)));
		Assert.assertEquals(-1, NS.getSign(toFrac(2, -3)));
	}

	private Fraction<Int32> toFrac(int v, int v2) {
		return Fraction.valueOf(Int32.valueOf(v), Int32.valueOf(v2));
	}
}
