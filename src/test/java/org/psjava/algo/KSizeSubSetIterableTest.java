package org.psjava.algo;

import org.junit.Test;
import org.psjava.ds.array.ArrayFromVarargs;

import static org.junit.Assert.*;

public class KSizeSubSetIterableTest {

    @Test
    public void testNormal() {
        assertEquals("((10,20),(10,30),(20,30))", KSizeSubSetIterable.create(ArrayFromVarargs.create(10, 20, 30), 2).toString());
        assertEquals("(())", KSizeSubSetIterable.create(ArrayFromVarargs.create(10, 20, 30), 0).toString());
        assertEquals("((10,20,30))", KSizeSubSetIterable.create(ArrayFromVarargs.create(10, 20, 30), 3).toString());
    }

    @Test(expected = RuntimeException.class)
    public void testTooBigK() {
        KSizeSubSetIterable.create(ArrayFromVarargs.create(10, 20, 30), 4);
    }

}