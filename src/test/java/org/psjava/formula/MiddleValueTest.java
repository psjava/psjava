package org.psjava.formula;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.DoubleNumberSystem;

public class MiddleValueTest {

    @Test
    public void test() {
        double r = MiddleValue.calc(DoubleNumberSystem.getInstance(), 1.0, 2.0, 0.2);
        Assert.assertEquals(1.2, r, 1e-10);
    }

}
