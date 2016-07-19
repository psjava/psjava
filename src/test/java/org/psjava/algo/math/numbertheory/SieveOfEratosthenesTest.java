package org.psjava.algo.math.numbertheory;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.math.numbertheory.SieveOfEratosthenes;
import org.psjava.ds.Collection;

public class SieveOfEratosthenesTest {
    @Test
    public void test() {
        Collection<Integer> r = SieveOfEratosthenes.getInstance().calcList(30);
        Assert.assertEquals("(2,3,5,7,11,13,17,19,23,29)", r.toString());
    }
}
