package org.psjava.algo.math.numbertheory;

import org.junit.Assert;
import org.junit.Test;

abstract public class PrimalityTesterTestBase {

    abstract protected PrimalityTester getInstance();

    @Test
    public void test1() {
        Assert.assertFalse(getInstance().isPrime(10));
        Assert.assertTrue(getInstance().isPrime(2));
        Assert.assertFalse(getInstance().isPrime(1));
    }

}
