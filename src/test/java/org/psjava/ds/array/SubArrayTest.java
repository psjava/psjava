package org.psjava.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubArrayTest {

    @Test
    public void test() {
        PSArray<Integer> a = SubArray.wrap(ArrayFromVarargs.create(1, 2, 3, 4, 5), 2, 4);
        assertEquals("(3,4)", a.toString());
    }

}