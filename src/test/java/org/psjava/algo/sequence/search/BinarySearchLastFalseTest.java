package org.psjava.algo.sequence.search;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

import java.util.function.Function;

public class BinarySearchLastFalseTest {

    @Test
    public void testNormal() {
        int actual = BinarySearchLastFalse.search(IntegerNumberSystem.getInstance(), new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer x) {
                return x >= 5;
            }
        }, 0, 10, -1);
        Assert.assertEquals(4, actual);
    }

}
