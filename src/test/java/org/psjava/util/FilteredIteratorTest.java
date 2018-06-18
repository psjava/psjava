package org.psjava.util;

import static org.junit.Assert.*;
import static org.psjava.TestUtil.toArrayList;

import org.junit.Test;
import org.psjava.TestUtil;

public class FilteredIteratorTest {

    @Test
    public void testCreate() {
        assertEquals(toArrayList(2, 4), TestUtil.toArrayListFromIterator(FilteredIterator.create(toArrayList(1, 2, 3, 4, 5).iterator(), v -> v % 2 == 0)));
    }

}
