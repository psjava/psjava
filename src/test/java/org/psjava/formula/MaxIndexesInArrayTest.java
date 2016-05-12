package org.psjava.formula;

import org.junit.Test;
import org.psjava.ds.array.MutableArrayUsingIntArray;
import org.psjava.util.DefaultComparator;

import static org.junit.Assert.*;

public class MaxIndexesInArrayTest {

    @Test
    public void testNormal() {
        assertEquals("(2,4)", get(1, 2, 3, 2, 3).toString());
    }

    @Test(expected = RuntimeException.class)
    public void testEmpty() {
        get();
    }

    private Iterable<Integer> get(int... v) {
        return MaxIndexesInArray.get(MutableArrayUsingIntArray.wrap(v), new DefaultComparator<Integer>());
    }

}