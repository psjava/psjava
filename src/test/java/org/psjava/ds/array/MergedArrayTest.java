package org.psjava.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergedArrayTest {

    @Test
    public void test() {
        assertEquals("(1,2,3,4)", MergedArray.wrap(ArrayFromVarargs.create(1, 2), ArrayFromVarargs.create(3, 4)).toString());
    }

}