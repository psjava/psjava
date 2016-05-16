package org.psjava.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MutableArrayUsingIntArrayTest {

    @Test
    public void test() {
        MutableArray<Integer> a = MutableArrayUsingIntArray.wrap(new int[]{1, 2, 3});
        a.set(1, 4);
        assertEquals("(1,4,3)", a.toString());
    }

}