package org.psjava.formula;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.MutableArrayFromVarargs;
import org.psjava.util.DefaultComparator;

public class MaxInIterableTest {

    private static final Comparator<Integer> COMP = new DefaultComparator<Integer>();

    @Test
    public void testMax() {
        PSArray<Integer> a = MutableArrayFromVarargs.create(1, 3, 2);
        assertEquals(3, (int) MaxInIterable.max(a, COMP));
    }

    @Test(expected = RuntimeException.class)
    public void testEmpty() {
        MaxInIterable.max(DynamicArray.<Integer>create(), COMP);
    }

}
