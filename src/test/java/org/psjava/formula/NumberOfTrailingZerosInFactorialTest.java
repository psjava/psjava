package org.psjava.formula;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class NumberOfTrailingZerosInFactorialTest {
    @Test
    public void test() {
        Assert.assertEquals(4, (int) NumberOfTrailingZerosInFactorial.calc(20, IntegerNumberSystem.getInstance()));
    }
}
