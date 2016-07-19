package org.psjava.formula;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.LongNumberSystem;

public class CeilingDivideTest {

    private static final LongNumberSystem NS = LongNumberSystem.getInstance();

    @Test
    public void testPositive() {
        Assert.assertEquals(4L, (long) CeilingDivide.calc(NS, 10L, 3L));
    }

    @Test(expected = ArithmeticException.class)
    public void testNegative() {
        CeilingDivide.calc(NS, -10L, 3L);
    }

}
