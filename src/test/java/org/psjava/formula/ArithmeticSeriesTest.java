package org.psjava.formula;

import org.junit.Assert;
import org.junit.Test;

import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.formula.ArithmeticSeries;

public class ArithmeticSeriesTest {
    @Test
    public void test() {
        int actual = ArithmeticSeries.calc(IntegerNumberSystem.getInstance(), 3, 2, 4); // 3+5+7+9
        Assert.assertEquals(24, actual);
    }
}
