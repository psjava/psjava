package org.psjava.ds.array;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.TestUtil;
import org.psjava.ds.array.ArrayRotator;

public class ArrayRotatorTest {

    @Test
    public void test1() {
        MutableArray<Integer> a = toArray(1, 2, 3, 4, 5);
        ArrayRotator.rotate(a, 2);
        Assert.assertEquals(TestUtil.toArrayList(3, 4, 5, 1, 2), TestUtil.toArrayListFromIterable(a));
    }

    @Test
    public void test2() {
        MutableArray<Integer> a = toArray(1, 2, 3, 4, 5);
        ArrayRotator.rotate(a, 0);
        Assert.assertEquals(TestUtil.toArrayList(1, 2, 3, 4, 5), TestUtil.toArrayListFromIterable(a));
    }

    private MutableArray<Integer> toArray(int... a2) {
        return MutableArrayUsingIntArray.wrap(a2);
    }

}
