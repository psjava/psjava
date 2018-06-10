package org.psjava.algo.sequence.search;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

import java.util.function.Function;

public class BinarySearchFirstTrueTest {

    private static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

    @Test
    public void test() {
        int actual = BinarySearchFirstTrue.search(NS, new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer index) {
                return index >= 100;
            }
        }, -10000, 10000, -1);
        Assert.assertEquals(100, actual);
    }

}
