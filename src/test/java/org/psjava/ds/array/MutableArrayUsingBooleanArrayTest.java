package org.psjava.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MutableArrayUsingBooleanArrayTest {

    @Test
    public void test() {
        MutableArray<Boolean> a = MutableArrayUsingBooleanArray.wrap(new boolean[]{true, false, false});
        a.set(1, true);
        assertEquals("(true,true,false)", a.toString());
    }

}