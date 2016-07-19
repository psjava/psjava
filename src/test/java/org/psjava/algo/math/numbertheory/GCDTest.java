package org.psjava.algo.math.numbertheory;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class GCDTest {

    private static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

    @Test
    public void test1() {
        Assert.assertEquals(8, (int) GCD.gcd(NS, 24, 16));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, (int) GCD.gcd(NS, 1, 123812733));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, (int) GCD.gcd(NS, 113213123, 1));
    }

}
