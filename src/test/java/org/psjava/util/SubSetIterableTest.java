package org.psjava.util;

import java.util.HashSet;


import org.junit.Assert;
import org.junit.Test;
import org.psjava.TestUtil;

public class SubSetIterableTest {

    @Test
    public void test() {
        Iterable<Integer> superSet = VarargsIterable.create(1, 2);
        HashSet<HashSet<Integer>> actual = new HashSet<HashSet<Integer>>();
        for (Iterable<Integer> sub : SubSetIterable.create(superSet))
            actual.add(TestUtil.toHashSet(sub));

        HashSet<HashSet<Integer>> expected = new HashSet<HashSet<Integer>>();
        for (Integer[] e : new Integer[][]{{}, {1}, {2,}, {1, 2}})
            expected.add(TestUtil.toHashSet(e));

        Assert.assertEquals(expected, actual);
    }

}
