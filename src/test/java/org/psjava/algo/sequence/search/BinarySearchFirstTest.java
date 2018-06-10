package org.psjava.algo.sequence.search;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.util.DefaultComparator;

import java.util.function.Function;

public class BinarySearchFirstTest {

    private static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

    @Test
    public void testNormal() {
        int actual = BinarySearchFirst.search(NS, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer key) {
                return key * 2;
            }
        }, new DefaultComparator<Integer>(), 0, 10000, 888, null);
        Assert.assertEquals(444, actual);
    }

    @Test
    public void testNagativeCase() {
        int actual = BinarySearchFirst.search(NS, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer key) {
                return key;
            }
        }, new DefaultComparator<Integer>(), -10000, 10000, -1000, null);
        Assert.assertEquals(-1000, actual);
    }

    @Test
    public void testNotFoundCase() {
        int actual = BinarySearchFirst.search(NS, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer index) {
                return 0;
            }
        }, new DefaultComparator<Integer>(), 0, 10, 2, -1);
        Assert.assertEquals(-1, actual);
    }

}
