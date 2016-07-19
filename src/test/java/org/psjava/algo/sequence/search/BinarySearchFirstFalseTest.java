package org.psjava.algo.sequence.search;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.sequence.search.BinarySearchFirstFalse;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class BinarySearchFirstFalseTest {

    @Test
    public void test() {
        int index = BinarySearchFirstFalse.search(IntegerNumberSystem.getInstance(), new Function<Integer, Boolean>() {
            @Override
            public Boolean get(Integer index) {
                return index < 400;
            }
        }, -10000, 10000, -1);
        Assert.assertEquals(400, index);
    }

}
