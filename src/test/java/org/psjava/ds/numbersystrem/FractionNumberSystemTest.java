package org.psjava.ds.numbersystrem;

import org.junit.Assert;
import org.junit.Test;

public class FractionNumberSystemTest {

    private static final FractionNumberSystem<Integer> NS = FractionNumberSystem.newInstance(IntegerNumberSystem.getInstance());

    @Test
    public void testBasicMath() {
        Fraction<Integer> add = NS.add(toFrac(12, 8), toFrac(3, 7));
        Assert.assertEquals(27, (int) add.numerator);
        Assert.assertEquals(14, (int) add.denominator);

        Fraction<Integer> sub = NS.subtract(toFrac(3, 7), toFrac(12, 8));
        Assert.assertEquals(-15, (int) sub.numerator);
        Assert.assertEquals(14, (int) sub.denominator);

        Fraction<Integer> mul = NS.multiply(toFrac(3, 7), toFrac(12, 8));
        Assert.assertEquals(9, (int) mul.numerator);
        Assert.assertEquals(14, (int) mul.denominator);

        Fraction<Integer> div = NS.divide(toFrac(6, 2), toFrac(3, 2));
        Assert.assertEquals(2, (int) div.numerator);
        Assert.assertEquals(1, (int) div.denominator);
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

    private Fraction<Integer> toFrac(int v, int v2) {
        return Fraction.valueOf(v, v2);
    }
}
