package org.psjava.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MutableArrayUsingLongArrayTest {

    @Test
    public void test() {
        MutableArray<Long> a = MutableArrayUsingLongArray.wrap(new long[]{1, 2, 3});
        a.set(1, 4L);
        assertEquals("(1,4,3)", a.toString());
    }

}