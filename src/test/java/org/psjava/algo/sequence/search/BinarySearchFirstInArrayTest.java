package org.psjava.algo.sequence.search;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.MutableArrayUsingIntArray;
import org.psjava.util.DefaultComparator;

public class BinarySearchFirstInArrayTest {

    private static final DefaultComparator<Integer> COMP = new DefaultComparator<Integer>();

    @Test
    public void test() {
        PSArray<Integer> a = MutableArrayUsingIntArray.wrap(new int[]{1, 3, 3, 5, 7, 9});
        Assert.assertEquals(1, BinarySearchFirstInArray.search(a, COMP, 3, -1));
        Assert.assertEquals(-1, BinarySearchFirstInArray.search(a, COMP, 6, -1));
    }

}
