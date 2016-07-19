package org.psjava.formula;

import org.junit.Assert;
import org.junit.Test;

public class IntegerBinaryLogarithmTest {
    @Test
    public void test() {
        Assert.assertEquals(3, IntegerBinaryLogarithm.calc(10));
        Assert.assertEquals(4, IntegerBinaryLogarithm.calc(16));
        Assert.assertEquals(0, IntegerBinaryLogarithm.calc(1));
    }

    @Test(expected = RuntimeException.class)
    public void testNonPositive() {
        Assert.assertEquals(-1, IntegerBinaryLogarithm.calc(0));
    }
}
