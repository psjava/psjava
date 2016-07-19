package org.psjava.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromVarargs;
import org.psjava.util.DefaultComparator;

import static org.junit.Assert.*;

public class NextPermutationTest {

    @Test
    public void testStep() {
        MutableArray<Integer> list = MutableArrayFromVarargs.create(1, 2, 3, 2, 1);
        boolean success = step(list);
        assertTrue(success);
        assertEquals("(1,3,1,2,2)", list.toString());
    }

    @Test
    public void testCannotStep() {
        MutableArray<Integer> list = MutableArrayFromVarargs.create(3, 2, 1);
        boolean success = step(list);
        assertFalse(success);
    }

    private static boolean step(MutableArray<Integer> list) {
        return NextPermutation.step(list, new DefaultComparator<Integer>());
    }

}