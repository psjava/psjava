package org.psjava.ds.array;

import org.junit.Assert;
import org.junit.Test;

public class MutableSubArrayTest {

    @Test
    public void testAffectingSuperArray() {
        MutableArray<Integer> a = MutableArrayFromVarargs.create(1, 2, 3, 4);
        MutableArray<Integer> sub = MutableSubArray.wrap(a, 1, 3);
        Assert.assertEquals("(2,3)", sub.toString());
        sub.set(1, 100);
        Assert.assertEquals("(1,2,100,4)", a.toString());
    }

}
