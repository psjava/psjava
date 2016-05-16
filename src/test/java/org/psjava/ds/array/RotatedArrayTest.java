package org.psjava.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotatedArrayTest {

    @Test
    public void test() {
        assertEquals("(3,4,5,1,2)", RotatedArray.wrap(ArrayFromVarargs.create(1, 2, 3, 4, 5), 2).toString());
    }

}