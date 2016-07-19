package org.psjava.formula;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class ModuloTest {

    @Test
    public void test() {
        IntegerNumberSystem ns = IntegerNumberSystem.getInstance();
        Assert.assertEquals(1, (int) Modulo.calc(ns, 10, 3));
        Assert.assertEquals(2, (int) Modulo.calc(ns, -10, 3));
    }
}
