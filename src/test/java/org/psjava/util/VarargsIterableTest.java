package org.psjava.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.psjava.TestUtil;
import org.psjava.util.VarargsIterable;

public class VarargsIterableTest {

    @Test
    public void testIterator() {
        Iterable<Integer> iterable = VarargsIterable.create(1, 2, 3);
        assertEquals(TestUtil.toArrayList(1, 2, 3), TestUtil.toArrayListFromIterable(iterable));
    }

}
