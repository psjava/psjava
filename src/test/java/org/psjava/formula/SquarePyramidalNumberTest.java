package org.psjava.formula;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class SquarePyramidalNumberTest {
    @Test
    public void test() {
        Assert.assertEquals(55, (int) SquarePyramidalNumber.calc(5, IntegerNumberSystem.getInstance()));
    }
}
