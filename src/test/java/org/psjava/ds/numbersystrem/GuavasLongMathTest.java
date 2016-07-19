package org.psjava.ds.numbersystrem;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.GuavasLongMath;

public class GuavasLongMathTest {

    @Test
    public void testCheckedAdd() {
        long r = GuavasLongMath.checkedAdd(1, 2);
        Assert.assertEquals(3, r);
    }

    @Test(expected = ArithmeticException.class)
    public void testCheckedAddOverflow() {
        GuavasLongMath.checkedAdd(Long.MAX_VALUE, 1);
    }

    @Test(expected = ArithmeticException.class)
    public void testCheckedSubtractOverflow() {
        GuavasLongMath.checkedSubtract(Long.MIN_VALUE, 1);
    }

    @Test(expected = ArithmeticException.class)
    public void testCheckedMultiplyOverflow() {
        GuavasLongMath.checkedMultiply(10000000000L, 10000000000L);
    }

}
