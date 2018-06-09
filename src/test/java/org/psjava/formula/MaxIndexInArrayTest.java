package org.psjava.formula;

import static org.junit.Assert.*;

import org.junit.Test;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.ArrayFromVarargs;
import org.psjava.ds.array.DynamicArray;
import org.psjava.util.DefaultComparator;

import java.util.Comparator;

public class MaxIndexInArrayTest {

    @Test
    public void testNormal() {
        PSArray<Integer> a = ArrayFromVarargs.create(1, 3, 2);
        assertEquals(1, MaxIndexInArray.get(a, COMP));
    }

    @Test(expected = RuntimeException.class)
    public void testEmpty() {
        DynamicArray<Integer> a = DynamicArray.create();
        MaxIndexInArray.get(a, COMP);
    }

    private static final Comparator<Integer> COMP = new DefaultComparator<Integer>();

}
