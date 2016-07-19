package org.psjava.util;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromVarargs;

public class IteratorToStringTest {

    @Test
    public void test() {
        MutableArray<Integer> a = MutableArrayFromVarargs.create(1, 2, 3, 4);
        Assert.assertEquals("(1,2,3,4)", IteratorToString.toString(a.iterator()));
    }
}
