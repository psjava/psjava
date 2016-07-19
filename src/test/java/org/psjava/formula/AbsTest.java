package org.psjava.formula;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class AbsTest {
    @Test
    public void test() {
        Assert.assertEquals(100, (int) Abs.calc(IntegerNumberSystem.getInstance(), 100));
        Assert.assertEquals(100, (int) Abs.calc(IntegerNumberSystem.getInstance(), -100));
        Assert.assertEquals(0, (int) Abs.calc(IntegerNumberSystem.getInstance(), 0));
    }
}
