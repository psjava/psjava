package org.psjava.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReversedArrayTest {

    @Test
    public void test() {
        assertEquals("(3,2,1)", ReversedArray.wrap(ArrayFromVarargs.create(1, 2, 3)).toString());
    }

}