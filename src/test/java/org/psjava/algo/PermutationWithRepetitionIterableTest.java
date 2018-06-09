package org.psjava.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.MutableArrayUsingIntArray;
import org.psjava.util.DefaultComparator;

public class PermutationWithRepetitionIterableTest {

    @Test
    public void test() {
        Assert.assertEquals("((0,1,2),(0,2,1),(1,0,2),(1,2,0),(2,0,1),(2,1,0))", create(1, 0, 2).toString());
        Assert.assertEquals("((1,1,2),(1,2,1),(2,1,1))", create(1, 2, 1).toString());
    }

    private Iterable<PSArray<Integer>> create(int... items) {
        return PermutationWithRepetitionIterable.create(MutableArrayUsingIntArray.wrap(items), new DefaultComparator<Integer>());
    }

}